package com.scut.itpm.umo.chat.down;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;
import com.scut.itpm.umo.data.chat.ChatMessageModel;

import java.util.List;

/**
 * Created by yaoyou on 2016/11/30.
 */

public interface chatDownConstract {
    interface View extends BaseView {
        void showChatMsgList(List<ChatMessageModel> chatMsgList);
        void NoChatMsgListt();

        String getMsg();
        String sendMsg();

        void showmore();
        void hidemore();
    }

    interface Presenter extends BasePresenter {
        void fetchChatMsgList();

        void sendTask();

    }
}
