package com.example.bxtyfufff.mytest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class WebeiwActivity extends Activity {
    String url="http://www.baidu.com/";
     private WebView webView;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webeiw);

        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);

        webView= (WebView) findViewById(R.id.webview  );
        initview();
    }

    private void initview() {
        webView.loadUrl(url);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    closedialog();
                } else {
                    opendialog(newProgress);
                }
            }
        });
    }

    private void opendialog(int newProgress) {
        if (dialog==null){
            getActionBar().setTitle(webView.getUrl());
            dialog=new ProgressDialog(WebeiwActivity.this);
            dialog.setTitle("加载中");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setProgress(newProgress);
        }else{
            dialog.setProgress(newProgress);
        }
        dialog.show();
    }


    private void closedialog() {
        if (dialog!=null)
        {
            dialog.dismiss();
        }
        dialog=null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if(webView.canGoBack()){
                webView.goBack();
                return true;
            }else{
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
