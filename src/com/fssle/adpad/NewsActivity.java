package com.fssle.adpad;

import android.os.Bundle;

import greendroid.app.GDActivity; 

public class NewsActivity extends GDActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
		setActionBarContentView(R.layout.main);  
    }
}
