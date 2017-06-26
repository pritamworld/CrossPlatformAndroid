package com.pritesh.crossplatformandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends AppCompatActivity
{
    WebView newsWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        newsWebView = (WebView)findViewById(R.id.mybrowser);
        newsWebView.setWebViewClient(new NewsClient());
        newsWebView.getSettings().setJavaScriptEnabled(true);
        newsWebView.getSettings().setDomStorageEnabled(true);
        newsWebView.loadUrl("file:///android_asset/news.html");
        //newsWebView.loadUrl("android_asset/www/index.html");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && newsWebView.canGoBack()) {
            newsWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class NewsClient extends WebViewClient
    {
        /*
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
        */

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl("javascript:changeLocation('" + url + "')");
            return true;
        }
    }
}
