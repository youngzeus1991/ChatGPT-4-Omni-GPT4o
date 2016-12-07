package com.scut.itpm.umo.data.follow.local;


import android.content.Context;

import com.scut.itpm.umo.data.FakeDataProvider;
import com.scut.itpm.umo.data.follow.FollowDataSource;
import com.scut.itpm.umo.data.follow.FollowModel;
import com.scut.itpm.umo.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/12/7.
 */

public class FollowLocalDateSource implements FollowDataSource {
    private static FollowLocalDateSource INSTANCE;

    public static FollowLocalDateSource getInstance(Context context){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new FollowLocalDateSource(context);
    }
    public FollowLocalDateSource(Context context) {

    }

    @Override
    public void getFollowList(GetFollowListCallback callback) {
        List<FollowModel> followModelList=new ArrayList<>();
        if(Constant.isFakeDataDebug){
            followModelList= FakeDataProvider.getFollowList();
        }
        else{

        }


        if(followModelList!=null&&followModelList.size()>0){
            callback.didGetFollowList(followModelList);
        }
        else {
            callback.followListNotAvailable();
        }
    }
}
