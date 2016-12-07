package com.scut.itpm.umo.core.announce;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;


/**
 * Created by DELL on 2016/11/2.
 */

public interface AnnounceContract {

    interface View extends BaseView {

        void setDefaultFragment();

        void showMapFragment();

        void showFeelingFragment();

        void showRequirementFragment();

    }

    interface Presenter extends BasePresenter {

        void informMapFragmentShouldShow();

        void informFeelingFragmentShouldShow();

        void informRequirementFragmentShouldShow();


    }
}
