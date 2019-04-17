package com.dixson.sharedparking.sharedparking.i.view;

import android.content.Context;
import android.view.View;

import com.dixson.sharedparking.R;
import com.dixson.sharedparking.sharedparking.base.BaseFragment;
import com.dixson.sharedparking.sharedparking.i.presenter.IPresenter;

public class IFragment extends BaseFragment {

    public String nowusername;
    public View view;
    public Context context;



    @Override
    public int getContentView() {
        IPresenter thisiPresenter = new IPresenter(context);
        return R.layout.personalinfo_main;
    }

    @Override
    public void initContentView(View viewContent) {

    }



}
