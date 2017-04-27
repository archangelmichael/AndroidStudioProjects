package com.example.radi.raytraining.activities;

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

    ArrayList<Todo> mTodoList;
    SimpleAdapter mTodoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        mTvTodoDate = (TextView) findViewById(R.id.tvTodoDate);
        String now = new Date().toString();
        mTvTodoDate.setText(now);

        mBtnAddTodo = (Button) findViewById(R.id.btnAddTodo);
        mBtnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new todo
            }
        });

        mLvTodo = (ListView) findViewById(R.id.lvTodo);

        mTodoList = new ArrayList<Todo>();
        mTodoList.add(new Todo("Intro", new Date()));

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (Todo item : mTodoList) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("title", item.getTitle());
            datum.put("date", item.getDate().toString());
            data.add(datum);
        }

        mTodoAdapter = new SimpleAdapter(
                this,
                data,
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


}
