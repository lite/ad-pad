package com.fssle.adpad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;         
import android.widget.TabHost;
                                  
import greendroid.app.GDTabActivity; 

public class SocialActivity extends GDTabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		Intent i=new Intent(this, BrowserActivity.class); 
		  
		TabHost host=getTabHost();
		
		final String feedText =  getString(R.string.feed_label);
		i.putExtra(BrowserActivity.URL, "http://www.google.com");
        // addTab(feedText, feedText, i); 
		host.addTab(host.newTabSpec(feedText).setIndicator(feedText).setContent(i));
 

        final String facebookText =  getString(R.string.facebook_label);
        i.putExtra(BrowserActivity.URL, "http://www.facebook.com");
        // addTab(facebookText, facebookText, i);
		host.addTab(host.newTabSpec(facebookText).setIndicator(facebookText).setContent(i));

        final String twitterText =  getString(R.string.twitter_label);
        i.putExtra(BrowserActivity.URL, "http://www.twitter.com");
        // addTab(twitterText, twitterText, i);
		host.addTab(host.newTabSpec(twitterText).setIndicator(twitterText).setContent(i));

        final String youtubeText =  getString(R.string.youtube_label);
        i.putExtra(BrowserActivity.URL, "http://www.youtube.com");
        // addTab(youtubeText, youtubeText, i);
		host.addTab(host.newTabSpec(youtubeText).setIndicator(youtubeText).setContent(i));

        final String foursquareText =  getString(R.string.foursquare_label);
        i.putExtra(BrowserActivity.URL, "http://www.foursquare.com");
        // addTab(foursquareText, foursquareText, i);
		host.addTab(host.newTabSpec(foursquareText).setIndicator(foursquareText).setContent(i));
    }
}
