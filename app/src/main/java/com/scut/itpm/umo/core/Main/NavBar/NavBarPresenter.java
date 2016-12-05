package com.scut.itpm.umo.core.Main.NavBar;

import com.scut.itpm.umo.core.Main.Connector;

/**
 * Created by DELL on 2016/11/2.
 */

public class NavBarPresenter implements NavBarContract.Presenter {

    private NavBarContract.View navBarContractView;
    private Connector.CallbackOnNavBar callbackOnNavBar;

    public NavBarPresenter(NavBarContract.View view, Connector.CallbackOnNavBar callback) {
        this.navBarContractView = view;
        this.callbackOnNavBar = callback;
        navBarContractView.setPresenter(this);
    }

    @Override
    public void setCurrentTitle(String currTitle) {
        navBarContractView.setCurrentTitle(currTitle);
    }

    @Override
    public void informMapFragmentShouldShow() {
        callbackOnNavBar.mapFragmentShouldShow();
    }

    @Override
    public void informFeelingFragmentShouldShow() {
        callbackOnNavBar.feelingFragmentShouldShow();
    }

    @Override
    public void informRequirementFragmentShouldShow() {
        callbackOnNavBar.requirementFragmentShouldShow();
    }

    @Override
    public void start() {

    }
}
