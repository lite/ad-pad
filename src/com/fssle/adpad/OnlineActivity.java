package com.fssle.adpad;  

import greendroid.app.GDActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;

public class OnlineActivity extends GDActivity {

  public static final String EXTRA_CONTENT_URL = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      final String contentUrl = getIntent().getStringExtra(EXTRA_CONTENT_URL);
      if (!TextUtils.isEmpty(contentUrl)) {
          setActionBarContentView(R.layout.web_view);
          final WebView webView = (WebView) findViewById(R.id.web_view);
              webView.loadUrl(contentUrl);

      }
  }

}           
	