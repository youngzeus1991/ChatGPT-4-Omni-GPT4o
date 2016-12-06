package com.scut.itpm.umo.data.message;

import android.content.Context;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class MessageRepository implements MessageDataSource{
    private static MessageRepository INSTANCE;

    private final MessageDataSource MessageLocalDataSource;

    private final MessageDataSource MessageRemoteDataSource;


    // Prevent direct instantiation.
    private MessageRepository(MessageDataSource MessagelocalDataSource,
                              MessageDataSource MessageremoteDataSource) {
        this.MessageRemoteDataSource = MessageremoteDataSource;
        this.MessageLocalDataSource = MessagelocalDataSource;
    }

    public static MessageRepository getINSTANCE(Context context,
                                                MessageDataSource MessagelocalDataSource,
                                                MessageDataSource MessageremoteDataSource){
        if (INSTANCE == null){
            INSTANCE = new MessageRepository(MessagelocalDataSource,MessageremoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void GetMessageList(GetMessageListCallback callback) {
        MessageLocalDataSource.GetMessageList(callback);
    }
}
