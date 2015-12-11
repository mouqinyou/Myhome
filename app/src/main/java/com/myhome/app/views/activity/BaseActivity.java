package com.myhome.app.views.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.myhome.app.R;

/**
 * Created by mqy on 2015-12-10.
 */
public class BaseActivity extends AppCompatActivity {

    private View emptyView = null;
    private TextView textViewEmpty;

    public View getEmptyView() {
        return getEmptyView("暂无数据");
    }

    public View getEmptyView(String textViewStr) {
        textViewEmpty = (TextView) emptyView.findViewById(R.id.textView_empty);
        textViewEmpty.setText(textViewStr);
        return emptyView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        emptyView = LayoutInflater.from(this).inflate(R.layout.view_empty, null);
    }
}
