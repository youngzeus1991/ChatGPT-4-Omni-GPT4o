package com.scut.itpm.umo.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.scut.itpm.umo.BaseActivity;
import com.scut.itpm.umo.R;
import com.scut.itpm.umo.chat.down.chatDownPresenter;
import com.scut.itpm.umo.chat.down.chatDownView;
import com.scut.itpm.umo.chat.top.chatTopPresenter;
import com.scut.itpm.umo.chat.top.chatTopView;
import com.scut.itpm.umo.util.RepositoryUtil;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class ChatActivity extends BaseActivity {

    private chatDownView chatdownview;
    private chatTopView chattopview;

    private chatDownPresenter chatpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        chatdownview = (chatDownView) findViewById(R.id.layout_chatdown);
        chattopview = (chatTopView) findViewById(R.id.layout_chattop);

        chattopview.setUserName(name);
        initPresenter();

        chatpresenter.start();
    }


    public void initPresenter(){
        chatTopPresenter chattoppresenter = new chatTopPresenter(chattopview);
        chatpresenter = new chatDownPresenter(chatdownview,chattoppresenter, RepositoryUtil.getChatMessageRepository(getApplicationContext()));

        chatdownview.setListener(chatpresenter);//为界面点击事件设置监听器
    }

}
