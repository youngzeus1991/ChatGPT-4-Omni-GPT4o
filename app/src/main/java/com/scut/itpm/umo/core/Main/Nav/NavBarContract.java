package com.scut.itpm.umo.core.Main.Nav;

import com.scut.itpm.umo.BaseController;
import com.scut.itpm.umo.BaseView;

/**
 * Created by DELL on 2016/11/2.
 */

public interface NavBarContract {
    interface View extends BaseView{
        void setCurrentTitle(String titleTobe);

    }
    interface Controller extends BaseController{
         void setCurrentTitle(String currTitle);
    }

}
