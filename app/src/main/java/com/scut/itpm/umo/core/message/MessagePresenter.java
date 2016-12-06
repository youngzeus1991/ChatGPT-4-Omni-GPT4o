package com.scut.itpm.umo.core.message;

import android.util.Log;

import com.scut.itpm.umo.data.message.MessageDataSource;
import com.scut.itpm.umo.data.message.MessageRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/11/2.
 */

public class MessagePresenter implements MessageContract.Presenter,Serializable{

    private MessageContract.View messageView;
    private MessageRepository messageRepository;

    public MessagePresenter(MessageContract.View messageView, MessageRepository messageRepository) {
        this.messageView = messageView;
        this.messageRepository = messageRepository;
        messageView.setPresenter(this);
    }

    @Override
    public void start() {
        //界面初始化
        fetchMessageList();
        Log.e("MessagePresenter:","start");
    }

    @Override
    public void fetchMessageList() {
        messageRepository.GetMessageList(new MessageDataSource.GetMessageListCallback() {
            @Override
            public void didGetMessageList(List<Map<String, Object>> MessageModelList) {
                messageView.showMessageList(MessageModelList);
                Log.e("messagelist:","show");
            }

            @Override
            public void MessageListNotAvailable() {
                messageView.showNOMessageList();

            }
        });
    }

    @Override
    public void send_later() {
        messageView.send_later();
    }

}
