package com.fssle.adpad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
// import android.widget.ListView;
                           
import greendroid.app.GDActivity;
import greendroid.widget.ActionBar;
import greendroid.widget.ActionBarItem.Type; 
// import greendroid.widget.ItemAdapter;         
// import greendroid.widget.item.TextItem; 

public class AdPadActivity extends GDActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
                                                  
		setActionBarContentView(R.layout.dashboard);

	    //attach event handler to dash buttons
	    DashboardClickListener dBClickListener = new DashboardClickListener();
	    findViewById(R.id.dashboard_button_news).setOnClickListener(dBClickListener);
	    findViewById(R.id.dashboard_button_map).setOnClickListener(dBClickListener);
	    findViewById(R.id.dashboard_button_events).setOnClickListener(dBClickListener);
	    findViewById(R.id.dashboard_button_schedule).setOnClickListener(dBClickListener);
	    findViewById(R.id.dashboard_button_riders).setOnClickListener(dBClickListener);
	    findViewById(R.id.dashboard_button_partners).setOnClickListener(dBClickListener);
	    findViewById(R.id.dashboard_button_share).setOnClickListener(dBClickListener);
	    findViewById(R.id.dashboard_button_social).setOnClickListener(dBClickListener);
	    //         
	  	// AdManager.setTestDevices( new String[] {
	  	// 	       AdManager.TEST_EMULATOR, // Android emulator
	  	// 	        "", // My HTC Hero Test Phone (IMEI number)
	  	// 	    } );      
    }

    // private TextItem createTextItem(int stringId, Class<?> klass) {
    //     final TextItem textItem = new TextItem(getString(stringId));
    //     textItem.setTag(klass);
    //     return textItem;
    // }
    // 
    // @Override
    // protected void onListItemClick(ListView l, View v, int position, long id) {
    //     final TextItem textItem = (TextItem) l.getAdapter().getItem(position);
    //     Intent intent = new Intent(AdPadActivity.this, (Class<?>) textItem.getTag());
    //     startActivity(intent);
    // } 

	private class DashboardClickListener implements OnClickListener {
	    @Override
	    public void onClick(View v) {
	        Intent i = null;     
 	        switch (v.getId()) {
	            case R.id.dashboard_button_news:
	                i = new Intent(AdPadActivity.this, NewsActivity.class);
	                break;
	            case R.id.dashboard_button_map:
	                i = new Intent(AdPadActivity.this, MapActivity.class);
	                break;
	            case R.id.dashboard_button_events:
	                i = new Intent(AdPadActivity.this, EventsActivity.class);
	                break;
	            case R.id.dashboard_button_schedule:
	                i = new Intent(AdPadActivity.this, ScheduleActivity.class);
	                break; 
	  		    case R.id.dashboard_button_riders:
	                i = new Intent(AdPadActivity.this, RidersActivity.class);
	                break;
	            case R.id.dashboard_button_partners:
	                i = new Intent(AdPadActivity.this, PartnersActivity.class);
	                break;
	            case R.id.dashboard_button_share:
	                i = new Intent(AdPadActivity.this, ShareActivity.class);
	                break;
	            case R.id.dashboard_button_social:
	                i = new Intent(AdPadActivity.this, SocialActivity.class);
	                break;
	            default:
	                break;
	        }
	        if(i != null) {
	            startActivity(i);
	        }
	    }
	}


}
