package com.myfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bxtyfufff.mytest.R;

/**
 * Created by Bxtyfufff on 2015/5/1.
 */
public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public void refresh(String newsTitle,String newsContent){
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText= (TextView) view.findViewById(R.id.news_title);
        TextView newContentText= (TextView) view.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsTitleText.setText(newsContent);
    }
}
