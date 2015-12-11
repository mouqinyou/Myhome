package com.myhome.app.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by mqy on 2015-12-11.
 */
public class ToastUtils {

    public static void ToastMakeText(Activity activity, String msg) {
        if (activity != null) {
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
        }
    }
}
