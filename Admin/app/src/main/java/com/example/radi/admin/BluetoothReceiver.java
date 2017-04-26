package com.example.radi.admin;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

public class BluetoothReceiver extends BroadcastReceiver {
    private static final String BLUETOOTH_PREFERENCES = "bluetooth_preferences";
    private static final String BLUETOOTH_STATE_KEY = "bluetooth_restricted_key";

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                    BluetoothAdapter.ERROR);
            final boolean isBluetoothRestricted = isBluetoothRestricted(context);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    break;
                case BluetoothAdapter.STATE_ON:
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    if (isBluetoothRestricted) {
                        Toast.makeText(context, "Bluetooth is restricted", Toast.LENGTH_SHORT).show();
                        setBluetoothActive(false);
                    }
                    break;
            }
        }
    }

    static public boolean isBluetoothActive(){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter != null && mBluetoothAdapter.isEnabled();
    }

    static public void setBluetoothActive(boolean active) {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            System.out.println("Device has no bluetooth");
            return;
        }

        if (active) {
            mBluetoothAdapter.enable();
        }
        else {
            mBluetoothAdapter.disable();
        }
    }

    static public boolean isBluetoothRestricted(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(BLUETOOTH_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPref.getBoolean(BLUETOOTH_STATE_KEY, false);
    }

    static public void setBluetoothRestricted(Context context, boolean restricted) {
        SharedPreferences sharedPref = context.getSharedPreferences(BLUETOOTH_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(BLUETOOTH_STATE_KEY, restricted);
        editor.commit();
    }
}
