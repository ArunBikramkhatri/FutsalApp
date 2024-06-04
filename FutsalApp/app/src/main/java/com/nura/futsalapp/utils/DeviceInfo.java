package com.nura.futsalapp.utils;

import android.os.Build;
import android.util.Log;

public class DeviceInfo {

    private static final String TAG = DeviceInfo.class.getSimpleName();

    public String getAndroidVersion() {
        String version = "test";
        try {
            version = "Android version: " + Build.VERSION.RELEASE +
                    "\nSDK: " + Build.VERSION.SDK_INT +
                    "\nCodename: " + Build.VERSION.CODENAME;
        } catch (Exception ex) {
            Log.e(TAG, ex.getLocalizedMessage(), ex);
            ex.printStackTrace();
        }
        return version;
    }
}

