package com.fssle.adpad;
                          
import android.os.Bundle;
import android.view.View; 
import android.widget.ListView; 
import android.widget.AdapterView;  
import android.content.res.ColorStateList;
import android.content.res.Resources;  
import android.content.res.XmlResourceParser; 
import android.graphics.drawable.Drawable;


import java.util.ArrayList;
 
import com.google.ads.*;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView; 
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
 
import greendroid.app.GDMapActivity;
import greendroid.graphics.drawable.DrawableStateSet;
import greendroid.graphics.drawable.MapPinDrawable;
import greendroid.widget.ItemAdapter;   

// import greendroid.app.GDActivity;
// import greendroid.widget.ItemAdapter;

public class MapScreenActivity extends GDMapActivity
{    
	private static final OverlayItem[] items = {
        new OverlayItem(new GeoPoint(40714400, -74006000), "New York City", null),
        new OverlayItem(new GeoPoint(39952300, -75163800), "Philadelphia", null),
        new OverlayItem(new GeoPoint(38895100, -77036400), "Washington", null),
        new OverlayItem(new GeoPoint(41374800, -83651300), "Bowling Green", null),
        new OverlayItem(new GeoPoint(42331400, -83045800), "Detroit", null)
    };
	
	private AdView adView;
	private ListView listView;
	private MapView mapView;
	                         
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); 

        // setContentView(R.layout.mapscreen);
		setActionBarContentView(R.layout.mapscreen); 
        
	    adView = (AdView)this.findViewById(R.id.ad_view);
	    adView.loadAd(new AdRequest());
	
		listView = (ListView) findViewById(R.id.list_view); 
		mapView = (MapView) findViewById(R.id.map_view);
		
		try {
        	ItemAdapter adapter;
			adapter = ItemAdapter.createFromXml(this, R.xml.events_items);
        	listView.setAdapter(adapter);
        	listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	                MyLog.v("changdoc", "Cliecked?");
            	}
        	}); 

		    mapView.setBuiltInZoomControls(true);
			final Resources r = getResources();

			XmlResourceParser xpp = getResources().getXml(R.color.map_pin);                       
	        ColorStateList csl = ColorStateList.createFromXml(r, xpp);
	        BasicItemizedOverlay itemizedOverlay = new BasicItemizedOverlay(new MapPinDrawable(r, csl, csl));

	        for (int j = 0; j < items.length; j++) {
	            itemizedOverlay.addOverlay(items[j]);
	        }

	        mapView.getOverlays().add(itemizedOverlay);
       	} catch (Exception e) {
           e.printStackTrace();
       	}
    
	   	
    } 

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    } 
      
	private class BasicItemizedOverlay extends ItemizedOverlay<OverlayItem> {

        private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();

        public BasicItemizedOverlay(Drawable defaultMarker) {
            super(boundCenterBottom(defaultMarker));
        }

        public void addOverlay(OverlayItem overlay) {
            mOverlays.add(overlay);
            populate();
        }

        @Override
        protected OverlayItem createItem(int i) {
            return mOverlays.get(i);
        }

        @Override
        public int size() {
            return mOverlays.size();
        }

        @Override
        protected boolean onTap(int index) {
            return true;
        }
    }
}
