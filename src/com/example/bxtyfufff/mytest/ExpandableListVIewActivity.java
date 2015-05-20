package com.example.bxtyfufff.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Bxtyfufff on 2015/5/6.
 */
public class ExpandableListVIewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandabletlistview);
        ExpandableListAdapter expandableListAdapter=new BaseExpandableListAdapter() {
            int [] logos=new int[]{
                    R.drawable.ic_launcher,
                    R.drawable.ic_launcher,
                    R.drawable.ic_launcher
            };
            private  String[] colegetapy=new String[]{
                    "计算机","土木工程","音乐舞蹈"
            };
            private String[][] colege=new String[][]{
                    {"计算机科学与技术","网络工程","软件工程"},
                    {"土木工程","工程造价","机械工程","搬砖"},
                    {"音乐","舞蹈","影视"}
            };
            /*
            返回包含的组列表项的数量
             */
            @Override
            public int getGroupCount() {
                return colegetapy.length;
            }
            /*
            返回特定组包含的子列表数量
             */
            @Override
            public int getChildrenCount(int groupPosition) {
                return colege[groupPosition].length;
            }
            /*
            获取指定组的组数据
             */
            @Override
            public Object getGroup(int groupPosition) {
                return colegetapy[groupPosition];
            }
            /*
            返回指定组、指定子列表项的数据
             */
            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return colege[groupPosition][childPosition];
            }
            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
            /*
            该方法决定每个组选项的外观！
             */
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout  linearLayout=new LinearLayout(ExpandableListVIewActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView=new ImageView(ExpandableListVIewActivity.this);
                imageView.setImageResource(logos[groupPosition]);
                TextView textView=new TextView(ExpandableListVIewActivity.this);
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }
            /*
            该方法决定每个子项的外观！
             */
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView itemtextview = new TextView(ExpandableListVIewActivity.this);
                itemtextview.setTextSize(25);
                itemtextview.setText(getChild(groupPosition,childPosition).toString());
                return itemtextview;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }
        };
        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.expandablelv);
        expandableListView.setAdapter(expandableListAdapter);

    }
}
