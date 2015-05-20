package com.example.bxtyfufff.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;


public class FragmentActivity extends Activity{
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
//        bt= (Button) findViewById(R.id.bt_left);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Anotherright_fragmetn fragment = new Anotherright_fragmetn();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction transaction = fm.beginTransaction();
//                transaction.replace(R.id.right_fragment, fragment);
//                transaction.commit();
//            }
//        });
    }
}
