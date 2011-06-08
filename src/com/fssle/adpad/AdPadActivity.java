package com.fssle.adpad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
                           
import greendroid.app.GDListActivity;      
import greendroid.widget.ItemAdapter;         
import greendroid.widget.item.TextItem;

public class AdPadActivity extends GDListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);  
   
        ItemAdapter adapter = new ItemAdapter(this);
        adapter.add(createTextItem(R.string.news_label, NewsActivity.class));
        adapter.add(createTextItem(R.string.map_label, MapActivity.class));
        adapter.add(createTextItem(R.string.events_label, EventsActivity.class));
        adapter.add(createTextItem(R.string.schedule_label, ScheduleActivity.class));
        adapter.add(createTextItem(R.string.riders_label, RidersActivity.class));
        adapter.add(createTextItem(R.string.partners_label, PartnersActivity.class));
        adapter.add(createTextItem(R.string.share_label, ShareActivity.class));
        adapter.add(createTextItem(R.string.social_label, SocialActivity.class)); 

        setListAdapter(adapter);
    }

    private TextItem createTextItem(int stringId, Class<?> klass) {
        final TextItem textItem = new TextItem(getString(stringId));
        textItem.setTag(klass);
        return textItem;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        final TextItem textItem = (TextItem) l.getAdapter().getItem(position);
        Intent intent = new Intent(AdPadActivity.this, (Class<?>) textItem.getTag());
        startActivity(intent);
    }
}
