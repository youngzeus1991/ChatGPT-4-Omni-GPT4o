package com.scut.itpm.umo.core.Main;

import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.scut.itpm.umo.core.Main.Nav.NavBarContract;

/**
 * Created by DELL on 2016/11/2.
 */

public class MainController implements MainContract.Controller, RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{

    private MainContract.View mainView;
    private NavBarContract.Controller navBarController;
    public MainController(MainContract.View view, NavBarContract.Controller navBarController) {
        this.mainView=view;
        this.navBarController=navBarController;
    }

    @Override
    public void setNavBarTitle(String titleToBe) {
        navBarController.setCurrentTitle(titleToBe);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        mainView.onCheckChange(i);
        String titleToBe=mainView.getCurrTitle(i);
        navBarController.setCurrentTitle(titleToBe);
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
        navBarController.start();
    }
}
