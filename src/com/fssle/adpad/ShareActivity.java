package com.fssle.adpad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;   

import greendroid.app.GDTabActivity; 

public class ShareActivity extends GDTabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		final String shareText =  getString(R.string.share_label);
		final Intent shareIntent = new Intent(this, OnlineActivity.class);
        shareIntent.putExtra(OnlineActivity.EXTRA_CONTENT_URL, "http://www.flickr.com/photos/tags/blue/");
        addTab(shareText, shareText, shareIntent);  

        final String uploadsText =  getString(R.string.uploads_label);
        final Intent uploadsIntent = new Intent(this, OnlineActivity.class);
        uploadsIntent.putExtra(OnlineActivity.EXTRA_CONTENT_URL, "http://www.flickr.com/photos/bigdani/");
        addTab(uploadsText, uploadsText, uploadsIntent);
    }
    
    @Override
    public int createLayout() {
        return R.layout.share;
    }
}