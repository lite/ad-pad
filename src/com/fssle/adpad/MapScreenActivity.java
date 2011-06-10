package com.fssle.adpad;
                          
import android.os.Bundle;
 
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import android.os.Bundle;

import com.google.android.maps.MapView;

// import greendroid.app.GDActivity;
// import greendroid.widget.ItemAdapter;

public class MapScreenActivity extends MapActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapscreen);

	   	MapView mapView = (MapView) findViewById(R.id.map_view);
		mapView.setBuiltInZoomControls(true);
		mapView.postInvalidate();
    }  

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }

	@Override
	protected void onResume() {
		AdsUtils.setupAd(this);
		super.onResume();
	}  
	
	@Override
	protected void onDestroy() {
	    AdsUtils.destroyAd(this);
		super.onDestroy();
	}
}
