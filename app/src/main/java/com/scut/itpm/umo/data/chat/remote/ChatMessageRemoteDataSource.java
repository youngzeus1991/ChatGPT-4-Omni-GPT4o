package com.scut.itpm.umo.data.chat.remote;

import android.content.Context;

import com.scut.itpm.umo.data.chat.ChatMessageDataSource;

/**
 * Created by yaoyou on 2016/12/1.
 */

public class ChatMessageRemoteDataSource implements ChatMessageDataSource{

    private static ChatMessageRemoteDataSource INSTANCE;

    public static ChatMessageRemoteDataSource getINSTANCE(Context context) {
        if (INSTANCE == null){
            INSTANCE = new ChatMessageRemoteDataSource(context);
        }
        return INSTANCE;
    }

    public ChatMessageRemoteDataSource(Context context) {
    }

    @Override
    public void getchatMessageList(GetChatMessageListCallBack callBack) {

    }

    @Override
    public void sengchatmsg(String string) {

    }
}
