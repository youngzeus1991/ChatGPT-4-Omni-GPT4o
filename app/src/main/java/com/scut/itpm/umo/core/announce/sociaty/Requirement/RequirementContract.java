package com.scut.itpm.umo.core.announce.sociaty.Requirement;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.util.List;

/**
 * Created by DELL on 2016/12/2.
 */

public interface RequirementContract {
    interface View extends BaseView , android.view.View.OnClickListener{
        void showRequirementList(List<RequirementModel> requirementModelList);
        void showNoRequirementList();
        void showRequirementDetail();
        void showNoRequirementDetail();

    }
    interface Presenter extends BasePresenter {
        void fetchRequirementList();
        void fetchRequirementDetail(int ID );

    }
}
