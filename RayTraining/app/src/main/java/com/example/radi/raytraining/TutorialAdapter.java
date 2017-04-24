package com.example.radi.raytraining;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by radi on 4/24/17.
 */

public class TutorialAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Tutorial> mDataSource;

    public TutorialAdapter(Context context, ArrayList<Tutorial> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.list_item_tutorial, parent, false);

        Tutorial tutorial = (Tutorial) getItem(position);

        TextView tvTitle = (TextView) rowView.findViewById(R.id.tvTutTitle);
        tvTitle.setText(tutorial.getTitle());

        TextView tvSubtitle = (TextView) rowView.findViewById(R.id.tvTutSubtitle);
        tvSubtitle.setText(tutorial.isComplete() ? "complete" : "incomplete");

        int rowColorId =  tutorial.isComplete() ? R.color.colorComplete : R.color.colorIncomplete;
        rowView.setBackgroundColor(ContextCompat.getColor(mContext, rowColorId));

        return rowView;
    }
}
