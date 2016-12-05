package com.scut.itpm.umo.chat.top;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;

/**
 * Created by yaoyou on 2016/11/30.
 */

public interface chatTopContract {
    interface View extends BaseView {
        void setUserName(String name);

    }
    interface Presenter extends BasePresenter {
        void setUserName(String Name);
    }
}
