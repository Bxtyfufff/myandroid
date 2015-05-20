package com.example.bxtyfufff.mytest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;


public class ReceiverActivity extends Activity {
    private IntentFilter intentFilter;
    NetworkChangeReceivier networkChangeReceivier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHSNGE");
        networkChangeReceivier=new NetworkChangeReceivier();
        registerReceiver(networkChangeReceivier,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceivier);
    }
    class NetworkChangeReceivier extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null  &&  networkInfo.isAvailable()){
                Toast.makeText(getApplicationContext(),"Newwork is Available",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Newwork is Unavailable",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
