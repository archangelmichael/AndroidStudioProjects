package com.example.radi.admin;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class NetworkReceiver extends BroadcastReceiver {

    private static final String WIFI_PREFERENCES = "wifi_preferences";
    private static final String WIFI_STATE_KEY = "wifi_restricted_key";

    @Override
    public void onReceive(final Context context, final Intent intent) {
        final ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) { // connected to wifi
                if (isWifiRestricted(context)) {
                    setWifiActive(context, false);
                    Toast.makeText(context, context.getText(R.string.msg_wifi_restricted), Toast.LENGTH_SHORT).show();
                }
            }
            else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) { // connected to the mobile provider's data plan
                // Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
            }
        }
        else { // not connected to the internet
            // Toast.makeText(context, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
        }
    }


    static public boolean isWifiActive(Context context){
        WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()) { // Wi-Fi adapter is ON
            WifiInfo wifiInfo = wifi.getConnectionInfo();
            if (wifiInfo.getNetworkId() == -1 ) { // Not connected to an access point
                return true;
            }
            else { // Connected to an access point
                return true;
            }
        }
        else {
            return false; // Wi-Fi adapter is OFF
        }
    }

    static public void setWifiActive(Context context, boolean active) {
        WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(active);
    }

    static public boolean isWifiRestricted(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(WIFI_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPref.getBoolean(WIFI_STATE_KEY, false);
    }

    static public void setWifiRestricted(Context context, boolean restricted) {
        SharedPreferences sharedPref = context.getSharedPreferences(WIFI_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(WIFI_STATE_KEY, restricted);
        editor.commit();
    }
}
