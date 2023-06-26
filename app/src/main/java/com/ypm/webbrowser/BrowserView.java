package com.ypm.webbrowser;

import android.graphics.Bitmap;


import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.CookieManager;
import android.webkit.WebSettings;

public class BrowserView extends AppCompatActivity {

    private String url;
    WebView web_view;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_view2);
        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        final WebView web_view = findViewById(R.id.webView);

        web_view.setVerticalScrollBarEnabled(true);
        web_view.requestFocus();
        web_view.getSettings().setDefaultTextEncodingName("utf-8");
        web_view.getSettings().setJavaScriptEnabled(true);


        final EditText urlET = findViewById(R.id.urlET);
        final ImageView homeBtn = findViewById(R.id.homeIcon);

        url = getIntent().getStringExtra("url");

        final String urlData = url.substring(0, 4);

        if (!urlData.contains("www.")) {
            url = "www.google.com/search?q=" + url;
        }

        urlET.setText(url);

        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                urlET.setText(url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        urlET.setOnEditorActionListener((v, actionId, event) -> {

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                final String urlTxt = urlET.getText().toString();

                if (!urlTxt.isEmpty()) {

                    final String urlData1 = urlTxt.substring(0, 4);

                    if (!urlData1.contains("www.")) {
                        url = "www.google.com/search?q=" + url;
                    } else {
                        url = urlTxt;
                    }

                }
            }
            return false;
        });

        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.loadUrl(url);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        web_view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {if(web_view!= null && web_view.canGoBack())
        web_view.goBack();          // if there is previous page open it
        else super.onBackPressed();      //if there is no previous page, close app
        }
    }
