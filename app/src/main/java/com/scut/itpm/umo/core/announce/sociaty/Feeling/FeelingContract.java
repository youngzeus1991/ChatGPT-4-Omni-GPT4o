package com.scut.itpm.umo.core.announce.sociaty.Feeling;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;
import com.scut.itpm.umo.data.announce.FeelingModel;

import java.util.List;

/**
 * Created by DELL on 2016/12/2.
 */

public interface FeelingContract {
    interface View  extends BaseView, android.view.View.OnClickListener {
        void showFeelingList(List<FeelingModel> feelingList);

        void showFeelingDetail(FeelingModel feeling);
        void showNoFeelingList();
        void showNoFeelingDetail();

    }

    interface Presenter extends BasePresenter {
        void fetchFeelingList();

        void fetchFeelingDetail(int ID);
    }
}
