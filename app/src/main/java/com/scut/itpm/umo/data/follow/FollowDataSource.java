package com.scut.itpm.umo.data.follow;

import java.util.List;

/**
 * Created by DELL on 2016/12/7.
 */

public interface FollowDataSource {
    interface GetFollowListCallback{
        void didGetFollowList(List<FollowModel>followModelList);
        void followListNotAvailable();
    }

    void getFollowList(GetFollowListCallback callback);
}
