package com.fssle.adpad;  

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View; 
import android.content.SharedPreferences;    
import android.preference.PreferenceManager;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdView;

public class AdsUtils {

    private static final String TAG = AdsUtils.class.getSimpleName();
    private static boolean DEBUG = false;
    private static Boolean showingAds = null;
    public static final boolean AD_ENABLED = true;                   
    public static final String PREFS_ADS = "pAds";
    public static final boolean PREFS_ADS_DEFAULT = true;

	public static void setupAd(Activity activity) {
		MyLog.v(TAG, "setupAd()");

		View adLayout = activity.findViewById(R.id.ad_layout);
		if (AD_ENABLED && isShowingAds(activity)) {
			// show ads
			if (adLayout != null) {
				adLayout.setVisibility(View.VISIBLE);
				AdView adView = (AdView) adLayout.findViewById(R.id.ads);
				if (adView != null) {
					adView.setVisibility(View.VISIBLE);
					AdRequest adRequest = new AdRequest();
					if (DEBUG) {
						adRequest.setTesting(true);
						adView.setAdListener(new AdListener() {
							@Override
							public void onDismissScreen(Ad ad) {
								MyLog.v(TAG, "onDismissScreen()");
							}

							@Override
							public void onFailedToReceiveAd(Ad ad, ErrorCode errorCode) {
								MyLog.v(TAG, "onFailedToReceiveAd()");
								MyLog.w(TAG, "Failed to received ad! Error code: '%s'.", errorCode);
							}

							@Override
							public void onLeaveApplication(Ad ad) {
								MyLog.v(TAG, "onLeaveApplication()");
							}

							@Override
							public void onPresentScreen(Ad ad) {
								MyLog.v(TAG, "onPresentScreen()");
							}

							@Override
							public void onReceiveAd(Ad ad) {
								MyLog.v(TAG, "onReceiveAd()");
							}
						});
					}
					adView.loadAd(adRequest);
				}
			}
		} else {
			// hide ads
			if (adLayout != null) {
				adLayout.setVisibility(View.GONE);
				AdView adView = (AdView) adLayout.findViewById(R.id.ads);
				if (adView != null) {
					adView.setVisibility(View.GONE);
				}
			}
		}
	}

	public static void destroyAd(Activity activity) {
		if (AD_ENABLED && isShowingAds(activity)) {
			View adLayout = activity.findViewById(R.id.ad_layout);
			if (adLayout != null) {
				AdView adView = (AdView) adLayout.findViewById(R.id.ads);
				if (adView != null) {
					adView.stopLoading();
				}
			}
		}
	}

	public static boolean isShowingAds(Context context) {
		MyLog.v(TAG, "isShowingAds()");
		if (AdsUtils.showingAds == null) {
			SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
			AdsUtils.showingAds = settings.getBoolean(PREFS_ADS, PREFS_ADS_DEFAULT); 
		}
		return AD_ENABLED ? AdsUtils.showingAds : AD_ENABLED;
	}

	public static void setShowingAds(Boolean showingAds) {
		AdsUtils.showingAds = showingAds;
	}
}
