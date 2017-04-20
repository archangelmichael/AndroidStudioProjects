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

    private boolean bluetoothOn = false;
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private final BroadcastReceiver btReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF:
                        setButtonText("Bluetooth off");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        setButtonText("Turning Bluetooth off...");
                        if (bluetoothOn) {
                            enableBluetooth(true);
                        }
                        break;
                    case BluetoothAdapter.STATE_ON:
                        setButtonText("Bluetooth on");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        setButtonText("Turning Bluetooth on...");
                        if (!bluetoothOn) {
                            enableBluetooth(false);
                        }
                        break;
                }
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register for broadcasts on BluetoothAdapter state change
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(btReceiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Unregister broadcast listeners
        unregisterReceiver(btReceiver);
    }


    private void setButtonText(String text) {
        TextView tvOutput = (TextView) findViewById(R.id.tvResult);
        tvOutput.setText(text);
    }


    // BLUETOOTH ACTIONS
    public void onCheckBluetooth(View view) {
        if (mBluetoothAdapter == null) {
            System.out.println("Device has no bluetooth");
        }
        else {
            if (mBluetoothAdapter.isEnabled()) { // Disable it
                enableBluetooth(false);
            }
            else { // Enable it
                enableBluetooth(true);
            }
        }
    }

    private void enableBluetooth (boolean enable) {
        if (enable) {
            mBluetoothAdapter.enable();
            bluetoothOn = true;
            setButtonText("Bluetooth on");
        }
        else {
            mBluetoothAdapter.disable();
            bluetoothOn = false;
            setButtonText("Bluetooth off");
        }
    }
}
