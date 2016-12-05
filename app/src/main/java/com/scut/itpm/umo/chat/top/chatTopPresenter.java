package com.scut.itpm.umo.chat.top;

import android.view.View;
import android.widget.Button;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class chatTopPresenter implements chatTopContract.Presenter,Button.OnClickListener{

   private chatTopContract.View chatTopView;

    public chatTopPresenter(chatTopContract.View chatTopView) {
        this.chatTopView = chatTopView;
        this.chatTopView.setPresenter(this);
//        this.chatTopView.setListener();
    }

    @Override
    public void setUserName(String Name) {
        chatTopView.setUserName(Name);
    }

    @Override
    public void start() {

    }

    @Override
    public void onClick(View v) {

    }
}
