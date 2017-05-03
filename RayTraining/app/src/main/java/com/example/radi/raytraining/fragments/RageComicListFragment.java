package com.example.radi.raytraining.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.radi.raytraining.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RageComicListFragment extends Fragment {

    public interface OnRageComicSelected {
        void onRageComicSelected(String name);
    }

    private OnRageComicSelected mListener;

    String[] mobileArray = {
            "Android",
            "IPhone",
            "WindowsMobile",
            "Blackberry",
            "WebOS",
            "Ubuntu",
            "Windows7",
            "Max OS X"
    };

    Context fragmentContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragmentContext = context;
        if (context instanceof OnRageComicSelected) {
            mListener = (OnRageComicSelected) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement OnRageComicSelected.");
        }
    }

    public static RageComicListFragment newInstance() {
        return new RageComicListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rage_comic_list, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = new ArrayAdapter<String>(fragmentContext,
                android.R.layout.simple_list_item_1, mobileArray);

        ListView listView = (ListView) getActivity().findViewById(R.id.comics_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rageSelected = mobileArray[position];
                mListener.onRageComicSelected(rageSelected);
            }
        });
    }
}
