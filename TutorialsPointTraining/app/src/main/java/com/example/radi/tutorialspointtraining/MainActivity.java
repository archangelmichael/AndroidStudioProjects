package com.example.radi.tutorialspointtraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.radi.tutorialspointtraining.activity.BasicActivity;
import com.example.radi.tutorialspointtraining.content_provider.ContentProviderActivity;
import com.example.radi.tutorialspointtraining.intent.IntentActivity;
import com.example.radi.tutorialspointtraining.service.ServiceActivity;

public class MainActivity extends AppCompatActivity {

    private String[] mTopics = {
            "Activity lifecycle",
            "Basic service",
            "Basic broadcast",
            "Content provider",
            "Basic intent"
    };

    ListView mTopicsListView;
    ArrayAdapter<String> mTopicsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopicsListView = (ListView) findViewById(R.id.lv_topics);
        mTopicsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mTopics);
        mTopicsListView.setAdapter(mTopicsAdapter);
        mTopicsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onTopicSelected(position);
            }
        });
    }

    private void onTopicSelected(int topicPosition) {
        switch (topicPosition) {
            case 0:
                Intent basicActivityIntent = new Intent(this, BasicActivity.class);
                startActivity(basicActivityIntent);
                break;
            case 1:
                Intent serviceActivityIntent = new Intent(this, ServiceActivity.class);
                startActivity(serviceActivityIntent);
                break;
            case 2:
                onBasicBroadcastSelected();
                break;
            case 3:
                Intent contentProviderActivityIntent = new Intent(this, ContentProviderActivity.class);
                startActivity(contentProviderActivityIntent);
                break;
            case 4:
                Intent intentActivityIntent = new Intent(this, IntentActivity.class);
                startActivity(intentActivityIntent);
                break;
            default:
                break;
        }
    }

    private void onBasicBroadcastSelected() {
        Intent intent = new Intent();
        intent.setAction("com.example.radi.tutorialspointtraining.CUSTOM_BROADCAST_INTENT");
        sendBroadcast(intent);
    }
}
