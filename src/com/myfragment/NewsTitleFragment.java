package com.myfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.com.News.helper.News;
import com.com.News.helper.NewsAdapter;
import com.com.News.helper.NewsContentActivity;
import com.example.bxtyfufff.mytest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bxtyfufff on 2015/5/1.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView newTitleListVFIew;
    private List<News> newList;
    private NewsAdapter newsAdapter;
    private boolean isTwopane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newList=getNews();
        newsAdapter=new NewsAdapter(activity, R.layout.news_item,newList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        newTitleListVFIew= (ListView) view.findViewById(R.id.news_title_list_view);
        newTitleListVFIew.setAdapter(newsAdapter);
        newTitleListVFIew.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_frag)!=null){
            isTwopane=true;//可以找到，双叶模式
        }else{
            isTwopane=false;//单页模式
        }
    }


    private List<News> getNews() {
        List<News> newslist=new ArrayList<News>();
        News news1=new News();
        news1.setTitle("This is the first Title");
        news1.setContent("This is the content of the First Title,Can you get it? Are You Ok?");
        newslist.add(news1);
        News news2=new News();
        news2.setTitle("This is the second Title");
        news2.setContent("This is the content of the Second Title,Can you get it? Are You Ok?");
        newslist.add(news2);
        return newslist;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        News news=newList.get(i);
        Log.i("frag","isTwopane=="+isTwopane);
        if(isTwopane==true){
            NewsContentFragment newsContentFragment= (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_frag);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        }else{
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
        }
    }
}
