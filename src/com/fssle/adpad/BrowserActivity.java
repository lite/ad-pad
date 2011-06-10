package com.fssle.adpad;  

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// import greendroid.app.GDActivity;

public class BrowserActivity extends Activity {

  public static final String URL = "com.fssle.adpad.URL";
  private WebView browser;

  @Override
  public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
	
	browser=new WebView(this);
	setContentView(browser);
	browser.getSettings().setJavaScriptEnabled(true);
	browser.setWebViewClient(new WebViewClient() {
	    @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
        {
            // Handle the error
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    });
	browser.loadUrl(getIntent().getStringExtra(URL));
  }
}           
	