package com.myhome.app.views.activity;

import android.os.Handler;

import com.myhome.app.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by mqy on 2015-12-10.
 */

@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

    @AfterViews
    void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity_.intent(SplashActivity.this).start();
                finish();
            }
        }, 2000);

    }
}
