package com.coronavirus.android.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.coronavirus.android.R;

/**
 * 展示新闻内容的activity,只有一个webView，主要就是接收从NewsActivity传来的新闻的url
 * @author zjy
 */
public class NewsContentActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        Intent intent=getIntent();
        String contentUrl=intent.getStringExtra("url");
        WebView webView=findViewById(R.id.news_content);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(contentUrl);
        webView.setInitialScale(85);

        Toolbar toolbar=findViewById(R.id.news_content_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("新闻内容");
    }
}
