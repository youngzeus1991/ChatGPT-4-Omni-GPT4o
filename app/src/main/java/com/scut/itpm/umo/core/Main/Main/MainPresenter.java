package com.scut.itpm.umo.core.Main.Main;

import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.scut.itpm.umo.core.Main.Connector;

/**
 * Created by DELL on 2016/11/2.
 */

public class MainPresenter implements MainContract.Presenter, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private MainContract.View mainView;
    private Connector.CallbackOnMainView callbackOnMainView;

    public MainPresenter(MainContract.View view, Connector.CallbackOnMainView callback) {
        this.mainView = view;
        this.callbackOnMainView = callback;
        mainView.setPresenter(this);
    }

    @Override
    public void informNavBarChangeTitle(String titleToBe) {
        callbackOnMainView.navBarTitleShouldChange(titleToBe);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        mainView.onCheckChange(i);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

        mainView.onPageScrollStateChanged(state);


    }

    @Override
    public void start() {

        mainView.init();

    }
}
