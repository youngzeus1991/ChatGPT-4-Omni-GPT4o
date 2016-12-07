package com.scut.itpm.umo.data.follow;

import android.content.Context;

/**
 * Created by DELL on 2016/12/7.
 */

public class FollowRepository implements FollowDataSource{
    private static FollowRepository INSTANCE;
    private FollowDataSource localDateSource;
    private FollowDataSource remoteDateSource;

    public static FollowRepository getInstance(Context context,FollowDataSource localDataSource, FollowDataSource remoteDataSource){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new FollowRepository(localDataSource,remoteDataSource);
    }
    public FollowRepository(FollowDataSource localDateSource, FollowDataSource remoteDateSource) {
        this.localDateSource = localDateSource;
        this.remoteDateSource = remoteDateSource;
    }

    @Override
    public void getFollowList(GetFollowListCallback callback) {
        localDateSource.getFollowList(callback);
    }
}
