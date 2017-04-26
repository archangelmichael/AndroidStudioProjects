package com.example.radi.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkStates();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkStates();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void checkStates() {
        boolean isBluetoothActive = BluetoothReceiver.isBluetoothActive();
        boolean isBluetoothRestricted = BluetoothReceiver.isBluetoothRestricted(this);
        displayBluetoothState(isBluetoothActive, isBluetoothRestricted);

        boolean isWifiActive = NetworkReceiver.isWifiActive(this);
        boolean isWifiRestricted = NetworkReceiver.isWifiRestricted(this);
        displayWifiState(isWifiActive, isWifiRestricted);
    }

//    public void onTrackRestrictions(View view) {
//        startService(new Intent(getBaseContext(), GeneralService.class));
//    }
//
//    public void onStopTrackRestrictions(View view) {
//        stopService(new Intent(getBaseContext(), GeneralService.class));
//    }

    // REQUIRES
    // <uses-permission android:name="android.permission.BLUETOOTH"/>
    // <uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
    public void onChangeBluetooth(View view) {
        boolean isBluetoothRestricted = BluetoothReceiver.isBluetoothRestricted(this);
        if (isBluetoothRestricted) {
            BluetoothReceiver.setBluetoothRestricted(this, false);
            displayBluetoothState(BluetoothReceiver.isBluetoothActive(), false);
        }
        else {
            BluetoothReceiver.setBluetoothRestricted(this, true);
            BluetoothReceiver.setBluetoothActive(false);
            displayBluetoothState(false, true);
        }
    }

    private void displayBluetoothState(boolean active, boolean restricted) {
        TextView tvBluetooth = (TextView) findViewById(R.id.tvBluetoothState);
        tvBluetooth.setText(
                restricted ?
                        getText(R.string.msg_bluetooth_restricted) :
                        active ?
                                getText(R.string.msg_bluetooth_on) :
                                getText(R.string.msg_bluetooth_off));

        Button btnBluetooth = (Button) findViewById(R.id.btnBluetooth);
        btnBluetooth.setText(
                restricted ?
                        getText(R.string.btn_enable_bluetooth) :
                        getText(R.string.btn_disable_bluetooth));
    }

    // REQUIRES
    // <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    // <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
    public void onChangeWifi(View view) {
        boolean isWifiRestricted = NetworkReceiver.isWifiRestricted(this);
        if (isWifiRestricted) {
            NetworkReceiver.setWifiRestricted(this, false);
            displayWifiState(false, false);
        }
        else {
            NetworkReceiver.setWifiRestricted(this, true);
            NetworkReceiver.setWifiActive(this, false);
            displayWifiState(false, true);
        }
    }

    private void displayWifiState(boolean active, boolean restricted) {
        TextView tvWifi = (TextView) findViewById(R.id.tvWifiState);
        tvWifi.setText(
                restricted ?
                        getText(R.string.msg_wifi_restricted) :
                        active ?
                                getText(R.string.msg_wifi_on) :
                                getText(R.string.msg_wifi_off));

        Button btnWifi = (Button) findViewById(R.id.btnWifi);
        btnWifi.setText(
                restricted ?
                        getText(R.string.btn_enable_wifi) :
                        getText(R.string.btn_disable_wifi));
    }

    // REQUIRES
    // <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    // <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE"/>
    public void onCheckBattery(View view) {
        int batLevel = BatteryLevelReceiver.getBatteryPercentage(getApplicationContext());
        String batteryPercentage = String.format(" BATTERY LEVEL : %d", batLevel);
        Toast.makeText(getApplicationContext(), batteryPercentage, Toast.LENGTH_SHORT).show();
    }
}