package com.example.radi.admin;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    // REQUIRES
    // <uses-permission android:name="android.permission.BLUETOOTH"/>
    // <uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
    public void onChangeBluetooth(View view) {
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

    // REQUIRES
    // <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    // <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
    public void onChangeWifi(View view) {
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()) {
            wifi.setWifiEnabled(false);
        }
        else {
            wifi.setWifiEnabled(true);
        }
    }

    // REQUIRES
    // <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    // <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE"/>
    public void onChangeAdmin(View view) {

    }
}