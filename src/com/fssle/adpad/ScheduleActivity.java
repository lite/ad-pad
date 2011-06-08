package com.fssle.adpad;

import android.os.Bundle;

import greendroid.app.GDListActivity;
import greendroid.widget.ItemAdapter;

public class ScheduleActivity extends GDListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
		
		ItemAdapter adapter;
        try {
            adapter = ItemAdapter.createFromXml(this, R.xml.news_items);
            setListAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
