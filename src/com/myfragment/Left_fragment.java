package com.myfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bxtyfufff.mytest.R;

/**
 * Created by Bxtyfufff on 2015/4/30.
 */
public class Left_fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.left_fragment,container,false);
        return view;
    }
}

