package com.example.bxtyfufff.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends Activity {
    private GridView gridview;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> data;
    int[] drawable = { R.drawable.address_book, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock, R.drawable.games_control,
            R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
            R.drawable.speech_balloon, R.drawable.weather,
            R.drawable.world, R.drawable.youtube };
    String[] iconName = { "联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置",
            "语音", "天气", "浏览器", "Youtube"};
    Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_grid_view);
        gridview= (GridView) findViewById(R.id.gridview);
        data=new ArrayList<Map<String,Object>>();
        simpleAdapter=new SimpleAdapter(GridViewActivity.this,getdata(),R.layout.gridview_item,
                new String[]{"img","text"},
                new int[]{R.id.grid_img,R.id.grid_text});
        gridview.setAdapter(simpleAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (mToast == null) {
                    mToast = Toast.makeText(getApplicationContext(), iconName[i],
                            Toast.LENGTH_SHORT);
                } else {
                    mToast.setText(iconName[i]);
                }
                mToast.show();
            }
        });
    }
    public List<Map<String,Object>> getdata(){
        for (int i = 0; i < drawable.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", drawable[i]);
            map.put("text", iconName[i]);
            data.add(map);
        }
        return data;
    }
}
