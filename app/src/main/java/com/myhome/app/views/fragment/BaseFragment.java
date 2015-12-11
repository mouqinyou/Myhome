package com.myhome.app.views.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myhome.app.R;

/**
 * Created by mqy on 2015-12-11.
 */
public class BaseFragment extends Fragment {
    private View emptyView = null;
    private TextView textViewEmpty;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        emptyView = LayoutInflater.from(getActivity()).inflate(R.layout.view_empty, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public View getEmptyView(String textViewStr) {
        textViewEmpty = (TextView) emptyView.findViewById(R.id.textView_empty);
        textViewEmpty.setText(textViewStr);
        return emptyView;
    }

    public View getEmptyView() {
        return getEmptyView("暂无数据");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
