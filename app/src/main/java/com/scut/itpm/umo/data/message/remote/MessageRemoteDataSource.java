package com.scut.itpm.umo.data.message.remote;

import android.content.Context;

import com.scut.itpm.umo.data.message.MessageDataSource;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class MessageRemoteDataSource implements MessageDataSource{
    private static MessageRemoteDataSource INSTANCE;

    public MessageRemoteDataSource(Context context) {
    }

    public static MessageRemoteDataSource getINSTANCE(Context context) {
        if (INSTANCE == null){
            INSTANCE = new MessageRemoteDataSource(context);
        }
        return INSTANCE;
    }

//    public interface GitHubService {
//        @GET("users/{user}/repos")
//        Call<List<Repo>> listRepos(@Path("user") String user);
//    }

    @Override
    public void GetMessageList(GetMessageListCallback callback) {
//        List<Map<String,Object>> MessageList = new ArrayList<Map<String, Object>>();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .build();
//
//        GitHubService service = retrofit.create(GitHubService.class);
//
//        if(MessageList!=null&&MessageList.size()>0){
//            callback.didGetMessageList(MessageList);
//        }
//        else{
//            callback.MessageListNotAvailable();
//        }
    }


}
