package com.fssle.adpad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
                                  
import greendroid.app.GDTabActivity; 

public class SocialActivity extends GDTabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		final String feedText =  getString(R.string.feed_label);
		final Intent feedIntent = new Intent(this, OnlineActivity.class);
        feedIntent.putExtra(OnlineActivity.EXTRA_CONTENT_URL, "http://www.google.com");
        addTab(feedText, feedText, feedIntent);  

        final String facebookText =  getString(R.string.facebook_label);
        final Intent facebookIntent = new Intent(this, OnlineActivity.class);
        facebookIntent.putExtra(OnlineActivity.EXTRA_CONTENT_URL, "http://www.facebook.com");
        addTab(facebookText, facebookText, facebookIntent);

        final String twitterText =  getString(R.string.twitter_label);
        final Intent twitterIntent = new Intent(this, OnlineActivity.class);
        twitterIntent.putExtra(OnlineActivity.EXTRA_CONTENT_URL, "http://www.twitter.com");
        addTab(twitterText, twitterText, twitterIntent);

        final String youtubeText =  getString(R.string.youtube_label);
        final Intent youtubeIntent = new Intent(this, OnlineActivity.class);
        youtubeIntent.putExtra(OnlineActivity.EXTRA_CONTENT_URL, "http://www.youtube.com");
        addTab(youtubeText, youtubeText, youtubeIntent);

        final String foursquareText =  getString(R.string.foursquare_label);
        final Intent foursquareIntent = new Intent(this, OnlineActivity.class);
        foursquareIntent.putExtra(OnlineActivity.EXTRA_CONTENT_URL, "http://www.foursquare.com");
        addTab(foursquareText, foursquareText, foursquareIntent);
    }
    
    @Override
    public int createLayout() {
        return R.layout.social;
    } 

}
