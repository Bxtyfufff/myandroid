package com.com.News.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bxtyfufff.mytest.R;

import java.util.List;

/**
 * Created by Bxtyfufff on 2015/5/1.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private int resourveId;
    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourveId=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news=getItem(position);
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourveId,null);
        }else{
            view=convertView;
        }
        TextView newstitle= (TextView) view.findViewById(R.id.news_title);
        newstitle.setText(news.getTitle());
        return view;
    }
}
