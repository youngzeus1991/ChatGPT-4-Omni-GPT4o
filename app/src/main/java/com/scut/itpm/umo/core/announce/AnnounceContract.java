package com.scut.itpm.umo.core.announce;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;
import com.scut.itpm.umo.data.announce.AnnounceModel;

import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public interface AnnounceContract {
    interface View extends BaseView{
        void showAnnounceList(List<AnnounceModel> announceModelList);
        void showNoAnnounceList();

    }
    interface Presenter extends BasePresenter{
        void fetchAnnounceList();

    }
}
