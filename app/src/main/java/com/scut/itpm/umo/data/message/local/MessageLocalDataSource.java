package com.scut.itpm.umo.data.message.local;

import android.content.Context;

import com.scut.itpm.umo.data.FakeDataProvider;
import com.scut.itpm.umo.data.message.MessageDataSource;
import com.scut.itpm.umo.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class MessageLocalDataSource implements MessageDataSource{
    private static MessageLocalDataSource INSTANCE;

    public MessageLocalDataSource(Context context) {
    }

    public static MessageLocalDataSource getINSTANCE(Context context) {
        if (INSTANCE == null){
            INSTANCE = new MessageLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void GetMessageList(GetMessageListCallback callback) {
        List<Map<String,Object>> MessageList = new ArrayList<Map<String, Object>> ();

        if (Constant.isFakeDataDebug){
            MessageList = FakeDataProvider.getMessageList();
        }
        else {
            //进行数据库读取
        }

        if(MessageList!=null&&MessageList.size()>0){
            callback.didGetMessageList(MessageList);
        }
        else{
            callback.MessageListNotAvailable();
        }
    }
}
