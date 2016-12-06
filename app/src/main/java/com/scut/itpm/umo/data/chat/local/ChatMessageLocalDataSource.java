package com.scut.itpm.umo.data.chat.local;

import android.content.Context;

import com.scut.itpm.umo.data.FakeDataProvider;
import com.scut.itpm.umo.data.chat.ChatMessageDataSource;
import com.scut.itpm.umo.data.chat.ChatMessageModel;
import com.scut.itpm.umo.util.Constant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by yaoyou on 2016/12/1.
 */

public class ChatMessageLocalDataSource implements ChatMessageDataSource{
    private static ChatMessageLocalDataSource INSTANCE;

    List<ChatMessageModel> chatMessageModelList = new ArrayList<>();

    public static ChatMessageLocalDataSource getINSTANCE(Context context) {
        if (INSTANCE == null){
            INSTANCE = new ChatMessageLocalDataSource(context);
        }
        return INSTANCE;
    }

    public ChatMessageLocalDataSource(Context context) {
    }

    @Override
    public void getchatMessageList(GetChatMessageListCallBack callBack) {

        if (Constant.isFakeDataDebug){
            chatMessageModelList = FakeDataProvider.getChatMessageList();
        }
        else {
            //// TODO: 2016/12/1 进行数据库读取
        }

        if (chatMessageModelList!=null&&chatMessageModelList.size()>0){
            callBack.didgetChatMessageList(chatMessageModelList);
        }
        else {
            callBack.ChatMessageListNotAvailable();
        }

    }

    @Override
    public void sengchatmsg(String constring) {
        ChatMessageModel entity = new ChatMessageModel();
        entity.setDate(getDate());
//        entity.setName("");
        entity.setMsgType(false);
        entity.setText(constring);
        chatMessageModelList.add(entity);

    }

    //获取日期
    private String getDate() {
        Calendar c = Calendar.getInstance();
        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH));
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
        String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mins = String.valueOf(c.get(Calendar.MINUTE));
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":" + mins);
        return sbBuffer.toString();
    }
}

