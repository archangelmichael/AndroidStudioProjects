package com.example.radi.teleriktraining.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.radi.teleriktraining.R;

/**
 * Created by radi on 5/10/17.
 */

public class SuperheroAdapter extends BaseAdapter {
    private Context mContext;
    private Superhero[] mSuperheroes;

    public SuperheroAdapter(Context context, Superhero[] superheroes) {
        this.mContext = context;
        this.mSuperheroes = superheroes;
    }

    @Override
    public int getCount() {
        return mSuperheroes.length;
    }

    @Override
    public Object getItem(int position) {
        return mSuperheroes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SuperheroViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_superhero, parent, false);
            viewHolder = new SuperheroViewHolder();
            viewHolder.tvSuperheroAlias = (TextView) convertView.findViewById(R.id.tv_superhero_alias);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (SuperheroViewHolder) convertView.getTag();
        }

        Superhero superhero = (Superhero) this.getItem(position);

        if(superhero != null) {
            viewHolder.tvSuperheroAlias.setText(superhero.getAlias());
        }

        return convertView;
    }

    private static class SuperheroViewHolder {
        TextView tvSuperheroAlias;
    }
}
