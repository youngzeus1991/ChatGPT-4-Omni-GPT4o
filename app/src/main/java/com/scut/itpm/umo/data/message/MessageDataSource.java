package com.scut.itpm.umo.data.message;

import java.util.List;
import java.util.Map;

/**
 * Created by yaoyou on 2016/11/30.
 */

public interface MessageDataSource {

    interface GetMessageListCallback{

        void didGetMessageList(List<Map<String, Object>> MessageModelList);

        void MessageListNotAvailable();
    }

    void GetMessageList(GetMessageListCallback callback);
}
