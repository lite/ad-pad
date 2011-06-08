package com.fssle.adpad;

import android.content.Intent;
import android.net.Uri;
import greendroid.app.GDApplication;

public class AdPadApplication extends GDApplication {

    @Override
    public Class<?> getHomeActivityClass() {
        return AdPadActivity.class;
    }
}
