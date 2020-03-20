package com.coronavirus.android.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.coronavirus.android.R;
import com.google.android.material.navigation.NavigationView;

/**
 * 应用的主活动
 * @author zsy
 * zjy修改
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private static String url="http://map.dedsec.site";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

    }

    /**
     * 初始化视图及点击事件
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void initView(){
        Toolbar toolbar= findViewById(R.id.toolbar);
        NavigationView navigationView=findViewById(R.id.nav_view);
        mDrawerLayout= findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.nav_baseline);
        }

        WebView webView=findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        webView.setInitialScale(90);

        navigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    //进入新闻界面
                    case R.id.nav_news:
                        Intent startNews=new Intent(MainActivity.this,NewsActivity.class);
                        startActivity(startNews);
                        break;
                    //进入反馈界面
                    case R.id.nav_message:
                        //TODO
                        break;
                    //进入孔明灯祈福界面
                    case R.id.nav_light:
                        Intent startLight=new Intent(MainActivity.this, LightMainActivity.class);
                        startActivity(startLight);
                        break;
                    default:
                }
                return true;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.choose_activity:
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
            default:
        }
        return true;
    }

}
