package com.gini.apps.playlink;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PlayLinkInitProvider extends ContentProvider {

    private final static String TAG = PlayLinkInitProvider.class.getSimpleName();

    @Override
    public boolean onCreate() {
        PlayLinkSDK playLinkSDK = PlayLinkSDK.getInstance();

        if (playLinkSDK == null) {
            Log.i(TAG, "PlayLinkSDK initialization unsuccessful");
        } else {
            Log.i(TAG, "PlayLinkSDK initialization successful");
            playLinkSDK.changeSomePropertyToNewValue("GiniApps");
        }
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo == null) {
            throw new NullPointerException("PlayLinkInitProvider ProviderInfo cannot be null.");
        }
        // So if the authorities equal the library internal ones, the developer forgot to set his applicationId
        String path = BuildConfig.LIBRARY_PACKAGE_NAME + ".PlayLinkInitProvider";
        if (path.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a "
                    + "missing applicationId variable in application\'path build.gradle.");
        }
        super.attachInfo(context, providerInfo);
    }
}
