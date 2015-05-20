package com.example.bxtyfufff.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {
    ListView listview;
    ArrayAdapter<String > data;
    private String[] tests={"Fragment","GridView","Receiver","WebView","ExpandableListview"
    		,"Material"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,tests);
        listview= (ListView) findViewById(R.id.testlist);
        listview.setAdapter(data);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(MainActivity.this,FragmentActivity.class );
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(MainActivity.this,GridViewActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(MainActivity.this,ReceiverActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(MainActivity.this,WebeiwActivity.class );
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=new Intent(MainActivity.this,ExpandableListVIewActivity.class );
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5=new Intent(MainActivity.this,ExpandableListVIewActivity.class );
                        startActivity(intent5);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
