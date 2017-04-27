package com.example.radi.raytraining.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.radi.raytraining.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoActivity extends AppCompatActivity {

    TextView mTvTodoDate;
    Button mBtnAddTodo;
    ListView mLvTodo;
    List<Map<String, String>> mTodoData;

    ArrayList<Todo> mTodoList;
    SimpleAdapter mTodoAdapter;

    private BroadcastReceiver mTickReceiver;

    private static final int REQUEST_ADD_TODO = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        mTvTodoDate = (TextView) findViewById(R.id.tvTodoDate);
        mTickReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_TIME_TICK)) {
                    mTvTodoDate.setText(getCurrentTimeStamp());
                }
            }
        };

        mBtnAddTodo = (Button) findViewById(R.id.btnShowNewTodo);
        mBtnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent todoIntent = new Intent(TodoActivity.this, NewTodoActivity.class);
                startActivityForResult(todoIntent, REQUEST_ADD_TODO);
            }
        });

        mLvTodo = (ListView) findViewById(R.id.lvTodo);

        mTodoList = new ArrayList<Todo>();
        mTodoList.add(new Todo("Intro", new Date()));

        mTodoData = new ArrayList<Map<String, String>>();
        for (Todo item : mTodoList) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("title", item.getTitle());
            datum.put("date", item.getDate().toString());
            mTodoData.add(datum);
        }

        mTodoAdapter = new SimpleAdapter(
                this,
                mTodoData,
                android.R.layout.simple_list_item_2,
                new String[] {"title", "date"},
                new int[] {android.R.id.text1, android.R.id.text2});
        mLvTodo.setAdapter(mTodoAdapter);

        mLvTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                // Complete todo
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mTvTodoDate.setText(getCurrentTimeStamp());
        registerReceiver(mTickReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mTickReceiver != null) {
            try {
                unregisterReceiver(mTickReceiver);
            }
            catch (IllegalArgumentException e) {
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD_TODO && resultCode == RESULT_OK) {
            Todo newTodo = (Todo) data.getSerializableExtra("Todo");
            if (newTodo != null) {
                mTodoList.add(newTodo);

                Map<String, String> datum = new HashMap<String, String>(2);
                datum.put("title", newTodo.getTitle());
                datum.put("date", newTodo.getDate().toString());
                mTodoData.add(datum);
                mTodoAdapter.notifyDataSetChanged();
            }
        }
    }

    private String getCurrentTimeStamp() {
        return new Date().toString();
    }
}
