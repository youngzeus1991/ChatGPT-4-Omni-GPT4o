package com.scut.itpm.umo.data.follow.remote;


import android.content.Context;

import com.scut.itpm.umo.data.follow.FollowDataSource;

/**
 * Created by DELL on 2016/12/7.
 */

public class FollowRemoteDateSource implements FollowDataSource {
    private static FollowRemoteDateSource INSTANCE;

    public static FollowRemoteDateSource getInstance(Context context){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new FollowRemoteDateSource(context);
    }
    public FollowRemoteDateSource(Context context) {

    }
    @Override
    public void getFollowList(GetFollowListCallback callback) {
        
    }
}
