package com.scut.itpm.umo.core.Main;

import com.scut.itpm.umo.BaseController;
import com.scut.itpm.umo.BaseView;

/**
 * Created by DELL on 2016/11/2.
 */

public interface MainContract {
    interface View extends BaseView{
        void setNavBarTitle(String titleToBe);

        void onCheckChange(int i);
        void onPageScrollStateChanged(int state);
        void init();

        String getCurrTitle(int i);

    }
    interface Controller extends BaseController{
         void setNavBarTitle(String titleToBe);

    }
}
