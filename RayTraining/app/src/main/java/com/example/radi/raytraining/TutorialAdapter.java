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
        ViewHolder holder;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_tutorial, parent, false);

            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTutTitle);
            holder.tvSubtitle = (TextView) convertView.findViewById(R.id.tvTutSubtitle);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        TextView tvTitle = holder.tvTitle;
        TextView tvSubtitle = holder.tvSubtitle;
        Tutorial tutorial = (Tutorial) getItem(position);

        tvTitle.setText(tutorial.getTitle());
        tvSubtitle.setText(tutorial.isComplete() ? "complete" : "incomplete");
        int rowColorId =  tutorial.isComplete() ? R.color.colorComplete : R.color.colorIncomplete;
        tvSubtitle.setTextColor(ContextCompat.getColor(mContext, rowColorId));

        return convertView;
    }

    // ViewHolder pattern
    private static class ViewHolder {
        public TextView tvTitle;
        public TextView tvSubtitle;
    }
}
