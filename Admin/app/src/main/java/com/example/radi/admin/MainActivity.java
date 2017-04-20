package com.example.radi.admin;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void setButtonText(String text) {
        TextView tvOutput = (TextView) findViewById(R.id.tvResult);
        tvOutput.setText(text);
    }

    // BLUETOOTH ACTIONS
    public void onCheckBluetooth(View view) {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter != null) {
            if (mBluetoothAdapter.isEnabled()) {
                BluetoothReceiver.setBluetoothState(this.getApplicationContext(), false);
                setButtonText("Bluetooth off");
            }
            else {
                BluetoothReceiver.setBluetoothState(this.getApplicationContext(), true);
                setButtonText("Bluetooth on");
            }
        }
    }
}