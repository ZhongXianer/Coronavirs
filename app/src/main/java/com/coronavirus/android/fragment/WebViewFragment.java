package com.coronavirus.android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coronavirus.android.R;

/**
 * 展示webView的fragment
 * 构造方法中传入参数为将要展示的网页的url
 */
public class WebViewFragment extends Fragment {

    private String urlToLoad;

    public WebViewFragment(String urlToLoad){
        this.urlToLoad=urlToLoad;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.web_view_fragment,container,false);
        WebView webView=view.findViewById(R.id.news_web);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(urlToLoad);
        webView.setInitialScale(90);

        return view;
    }
}
