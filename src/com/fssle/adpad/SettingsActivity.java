package com.fssle.adpad; 
 
import android.view.View;
import android.app.AlertDialog;
import android.widget.TextView;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.Context; 
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;  
import android.preference.PreferenceManager;  

public class SettingsActivity extends PreferenceActivity 
{
    public static final String PREFS_ADS = "pAds";
    public static final boolean PREFS_ADS_DEFAULT = true;  
	public static final String PKG = "com.fssle.adpad";
   
 	private CheckBoxPreference adsCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);

		// ads dialog
		this.adsCheckBox = (CheckBoxPreference) findPreference(PREFS_ADS);
		this.adsCheckBox.setChecked(AdsUtils.isShowingAds(this));
		this.adsCheckBox.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) { 
				SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
				boolean isNowChecked = settings.getBoolean(PREFS_ADS, PREFS_ADS_DEFAULT);
				if (!isNowChecked) {
					return true;
				} else {
					AdsUtils.setShowingAds(isNowChecked);
					return false;
				}
			}
		});

	    // about dialog
		((PreferenceScreen) findPreference("pAbout")).setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {
				SettingsActivity.this.showAboutDialog();
				return false;
			}
		});
	}
	
	public void showAboutDialog() {
		String versionName = "";
		String versionCode = "";
		try {
			PackageInfo packageInfo = this.getPackageManager().getPackageInfo(PKG, 0);
			versionName = packageInfo.versionName;
			versionCode = String.valueOf(packageInfo.versionCode);
		} catch (Exception e) {
		}
		View view = this.getLayoutInflater().inflate(R.layout.about, null, false);
		// set the version
		TextView versionTv = (TextView) view.findViewById(R.id.version);
		versionTv.setText(this.getString(R.string.about_version, versionName, versionCode));

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(this.getString(R.string.app_name));
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setView(view);
		builder.setPositiveButton(this.getString(android.R.string.ok), null);
		builder.setCancelable(true);

		builder.create();
		builder.show();
	}

}
