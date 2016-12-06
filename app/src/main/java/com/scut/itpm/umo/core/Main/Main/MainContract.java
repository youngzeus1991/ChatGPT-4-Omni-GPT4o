package com.scut.itpm.umo.core.Main.Main;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;

/**
 * Created by DELL on 2016/11/2.
 */

public interface MainContract {
    interface View extends BaseView {
        void informNavBarChangeTitle();

        void onCheckChange(int i);

        void onPageScrollStateChanged(int state);

        void init();

        String getCurrTitle();

    }

    interface Presenter extends BasePresenter {
        void informNavBarChangeTitle(String titleToBe);

    }
}
