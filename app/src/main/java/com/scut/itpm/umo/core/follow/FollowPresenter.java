package com.scut.itpm.umo.core.follow;

import com.scut.itpm.umo.data.follow.FollowDataSource;
import com.scut.itpm.umo.data.follow.FollowModel;
import com.scut.itpm.umo.data.follow.FollowRepository;

import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public class FollowPresenter implements FollowContract.Presenter{
    private FollowContract.View followView;
    private FollowRepository followRepository;

    public FollowPresenter(FollowRepository followRepository, FollowContract.View followView) {
        this.followRepository = followRepository;
        this.followView = followView;
        this.followView.setPresenter(this);
    }

    @Override
    public void fetchFollowList() {
        followRepository.getFollowList(new FollowDataSource.GetFollowListCallback() {
            @Override
            public void didGetFollowList(List<FollowModel> followModelList) {
                followView.showFollowList(followModelList);
            }

            @Override
            public void followListNotAvailable() {
                followView.showNoFollowList();
            }
        });
    }

    @Override
    public void start() {
        fetchFollowList();
    }
}
