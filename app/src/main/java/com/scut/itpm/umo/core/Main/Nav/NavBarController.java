package com.scut.itpm.umo.core.Main.Nav;

/**
 * Created by DELL on 2016/11/2.
 */

public class NavBarController implements NavBarContract.Controller{

    private NavBarContract.View navBarContractView;

    public NavBarController(NavBarContract.View navBarContractView) {
        this.navBarContractView = navBarContractView;
        navBarContractView.setPresenter(this);
    }

    @Override
    public void setCurrentTitle(String currTitle) {
        navBarContractView.setCurrentTitle(currTitle);

    }

    @Override
    public void start() {

    }
}
