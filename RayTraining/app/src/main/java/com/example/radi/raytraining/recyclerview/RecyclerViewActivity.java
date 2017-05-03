package com.example.radi.raytraining.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.radi.raytraining.R;

import java.io.IOException;
import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements ImageRequester.ImageRequesterResponse {

    private ArrayList<Photo> mPhotosList;
    private ImageRequester mImageRequester;

    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;

    private RecyclerAdapter mAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_stars, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mPhotosList = new ArrayList<>();
        mImageRequester = new ImageRequester(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mGridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new RecyclerAdapter(mPhotosList);
        mRecyclerView.setAdapter(mAdapter);

        // Request new photo when scrolling
        setRecyclerViewScrollListener();

// Remove photo on swipe
        setRecyclerViewItemTouchListener();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mPhotosList.size() == 0) {
            requestPhoto();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_recycler_manager) {
            changeLayoutManager();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Return current last visible item position depending on grid or list view
    private int getLastVisibleItemPosition() {
        int itemCount;

        if (mRecyclerView.getLayoutManager().equals(mLinearLayoutManager)) {
            itemCount = mLinearLayoutManager.findLastVisibleItemPosition();
        }
        else {
            itemCount = mGridLayoutManager.findLastVisibleItemPosition();
        }

        return itemCount;
    }

    private void setRecyclerViewScrollListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int totalItemCount = mRecyclerView.getLayoutManager().getItemCount();
                if (!mImageRequester.isLoadingData() && totalItemCount == getLastVisibleItemPosition() + 1) {
                    requestPhoto();
                }
            }
        });
    }

    private void setRecyclerViewItemTouchListener() {
        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                mPhotosList.remove(position);
                mRecyclerView.getAdapter().notifyItemRemoved(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private void changeLayoutManager() {
        if (mRecyclerView.getLayoutManager().equals(mLinearLayoutManager)) {
            mRecyclerView.setLayoutManager(mGridLayoutManager);
            if (mPhotosList.size() == 1) {
                requestPhoto();
            }
        }
        else {
            mRecyclerView.setLayoutManager(mLinearLayoutManager);
        }
    }

    private void requestPhoto() {
        try {
            mImageRequester.getPhoto();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receivedNewPhoto(final Photo newPhoto) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPhotosList.add(newPhoto);
                mAdapter.notifyItemInserted(mPhotosList.size());
            }
        });
    }
}
