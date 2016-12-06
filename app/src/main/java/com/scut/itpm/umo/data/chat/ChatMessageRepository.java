package com.scut.itpm.umo.data.chat;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yaoyou on 2016/12/1.
 */

public class ChatMessageRepository implements ChatMessageDataSource{
    private static ChatMessageRepository INSTANCE;
    private ChatMessageDataSource chatmessageLocalDataSource;
    private ChatMessageDataSource chatmessageRemoteDataSource;

    //测试代码
    List<ChatMessageModel> chatMsgList = new ArrayList<>();

    public static ChatMessageRepository getINSTANCE(Context context, ChatMessageDataSource chatmessageLocalDataSource, ChatMessageDataSource chatmessageRemoteDataSource) {
        if (INSTANCE == null){
            INSTANCE = new ChatMessageRepository(chatmessageLocalDataSource,chatmessageRemoteDataSource);
        }
        return INSTANCE;
    }

    public ChatMessageRepository(ChatMessageDataSource chatmessageLocalDataSource, ChatMessageDataSource chatmessageRemoteDataSource) {
        this.chatmessageLocalDataSource = chatmessageLocalDataSource;
        this.chatmessageRemoteDataSource = chatmessageRemoteDataSource;
    }

    @Override
    public void getchatMessageList(final GetChatMessageListCallBack callBack) {
        //// TODO: 2016/12/1 获取聊天数据
        chatmessageLocalDataSource.getchatMessageList(callBack);

    }


    @Override
    public void sengchatmsg(String constring) {
        chatmessageLocalDataSource.sengchatmsg(constring);
    }
}
