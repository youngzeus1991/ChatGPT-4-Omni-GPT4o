package com.scut.itpm.umo.chat.down;

import android.view.View;
import android.widget.Button;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.chat.top.chatTopContract;
import com.scut.itpm.umo.core.message.MessagePresenter;
import com.scut.itpm.umo.data.chat.ChatMessageDataSource;
import com.scut.itpm.umo.data.chat.ChatMessageModel;
import com.scut.itpm.umo.data.chat.ChatMessageRepository;

import java.util.List;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class chatDownPresenter implements chatDownConstract.Presenter,Button.OnClickListener{

    private chatDownConstract.View view;
    private ChatMessageRepository repository;

    private chatTopContract.Presenter chattoppresenter;
    private MessagePresenter mespresenter;

    public chatDownPresenter(chatDownConstract.View view, chatTopContract.Presenter chattoppresenter, ChatMessageRepository repository) {
        this.view = view;
        this.chattoppresenter = chattoppresenter;
        this.repository=repository;
        view.setPresenter(this);
    }

    @Override
    public void start() {

        fetchChatMsgList();
    }

    public void fetchChatMsgList(){
        repository.getchatMessageList(new ChatMessageDataSource.GetChatMessageListCallBack() {
            @Override
            public void didgetChatMessageList(List<ChatMessageModel> chatMsgList) {
                view.showChatMsgList(chatMsgList);
            }

            @Override
            public void ChatMessageListNotAvailable() {
                view.NoChatMsgListt();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_send:
                sendTask();
                break;
            case R.id.id_more:
//                view.showmore();
                break;
        }
    }


    @Override
    public void sendTask() {
        String constring = view.getMsg();
        if (constring.length()>0) {
            repository.sengchatmsg(constring);
            view.sendMsg();
        }else{
            //todo 消息为空的情况
        }
    }
}
