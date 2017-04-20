package com.example.radi.admin;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

/**
 * Created by radi on 4/20/17.
 */

public class BluetoothReceiver extends BroadcastReceiver {
    public static final String BLUETOOTH_PREFERENCES = "bluetooth_preferences";
    public static final String BLUETOOTH_STATE_KEY = "bluetooth_state_key";

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                    BluetoothAdapter.ERROR);
            final boolean isBluetoothEnabled = getBluetoothState(context);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    if (isBluetoothEnabled) {
                        Toast.makeText(context, "Turning bluetooth on", Toast.LENGTH_SHORT).show();
                        setBluetoothState(context, true);
                    }

                    break;
                case BluetoothAdapter.STATE_ON:
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    if (!isBluetoothEnabled) {
                        Toast.makeText(context, "Turning bluetooth off", Toast.LENGTH_SHORT).show();
                        setBluetoothState(context, false);
                    }
                    break;
            }
        }
    }

    static public void setBluetoothState(Context context, boolean enabled) {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            System.out.println("Device has no bluetooth");
            return;
        }

        SharedPreferences sharedPref = context.getSharedPreferences(BLUETOOTH_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(BLUETOOTH_STATE_KEY, enabled);
        editor.commit();

        if (enabled) {
            mBluetoothAdapter.enable();
        }
        else {
            mBluetoothAdapter.disable();
        }
    }

    static private boolean getBluetoothState(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(BLUETOOTH_PREFERENCES, Context.MODE_PRIVATE);
        boolean enabled = sharedPref.getBoolean(BLUETOOTH_STATE_KEY, false);
        return enabled;
    }
}
