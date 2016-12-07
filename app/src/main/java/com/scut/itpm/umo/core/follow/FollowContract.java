package com.scut.itpm.umo.core.follow;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;
import com.scut.itpm.umo.data.follow.FollowModel;

import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public interface FollowContract {
    interface View extends BaseView, android.view.View.OnClickListener{
        void showFollowList(List<FollowModel>followList);
        void showNoFollowList();
        void showFollowDetail(FollowModel followModel);
        void showNoFollowDetail();
    }
    interface Presenter extends BasePresenter{
        void fetchFollowList();
        
    }
}
