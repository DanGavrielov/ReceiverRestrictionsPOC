package com.gini.apps.playlink;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class PlayLinkSDK {

    private final static String TAG = PlayLinkSDK.class.getSimpleName();

    public interface CompletionHandler {
        void onCompletion(boolean finished);
    }

    private static PlayLinkSDK sInstance;

    private PlayLinkSDK() {
        // private constructor
    }

    public static PlayLinkSDK getInstance() {
        if (sInstance == null) {
            synchronized (PlayLinkSDK.class) {
                if (sInstance == null) {
                    sInstance = new PlayLinkSDK();
                }
            }
        }
        return sInstance;
    }

    private String mSomeProperty;

    public String getSomeProperty() {
        return mSomeProperty;
    }

    public void changeSomePropertyToNewValue(String newValue) {
        Log.v(TAG, "changeSomePropertyToNewValue: " + newValue);
        this.mSomeProperty = newValue;
    }

    private static int count = 0;

    public void performAsynchronizeActionWithCompletionHandler(final CompletionHandler completion) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                count++;
                completion.onCompletion(count % 2 == 0);
            }
        }, 2 * 1000);
    }
}
