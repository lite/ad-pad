package com.fssle.adpad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;      
import android.widget.TabHost; 

import greendroid.app.GDTabActivity;

public class ShareActivity extends GDTabActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
		// setContentView (R.layout.web_view);
		// setActionBarContentView(R.layout.web_view);
        Intent i=new Intent(this, BrowserActivity.class);
	   
		TabHost host=getTabHost();
		
		final String shareText =  getString(R.string.share_label);
		// i.putExtra(BrowserActivity.URL, "http://www.flickr.com/photos/tags/blue/"); 
		i.putExtra(BrowserActivity.URL, "http://www.google.com.hk/imgcat?hl=zh-CN&catid=564&sa=h");
		// addTab(shareText, shareText, i);  
        host.addTab(host.newTabSpec(shareText).setIndicator(shareText).setContent(i));

        final String uploadsText =  getString(R.string.uploads_label);
        // i.putExtra(BrowserActivity.URL, "http://www.android.com");
        i.putExtra(BrowserActivity.URL, "http://www.google.com.hk/imgcat?hl=zh-CN&catid=603&sa=h");
		// addTab(uploadsText, uploadsText, i); 
		host.addTab(host.newTabSpec(uploadsText).setIndicator(uploadsText).setContent(i));   
    }

}