package com.timmy.alcprofileapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        WebView mwebview = findViewById(R.id.about_web_view);
        ProgressBar mprogressbar = findViewById(R.id.progressBar);
        WebSettings mwebsettings =  mwebview.getSettings();
        mwebsettings.setJavaScriptEnabled(true);
        mwebsettings.setLoadWithOverviewMode(true);
        mwebview.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
               // super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mprogressbar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mprogressbar.setVisibility(View.GONE);
            }


        });
        mwebview.loadUrl("https://andela.com/alc/");
        mwebview.setWebChromeClient(new WebChromeClient());
        mwebview.clearCache(true);
        mwebview.clearHistory();
        mwebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        loadView();

    }

    public void loadView(){
        }
}
