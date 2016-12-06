package com.scut.itpm.umo.data.chat;

import java.util.List;

/**
 * Created by yaoyou on 2016/12/1.
 */

public interface ChatMessageDataSource {

    interface GetChatMessageListCallBack{
        void didgetChatMessageList(List<ChatMessageModel> chatMsgList);

        void ChatMessageListNotAvailable();
    }

    //// TODO: 2016/12/1 定义数据源的职责
    void getchatMessageList(GetChatMessageListCallBack callback);

    void sengchatmsg(String constring);
}
