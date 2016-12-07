package com.scut.itpm.umo.network;

import com.scut.itpm.umo.data.announce.AnnounceDataSource;

/**
 * Created by DELL on 2016/12/6.
 */

public interface HTTPContract {
    void getRequirementList(AnnounceDataSource.GetRequirementListCallback callback);
    void getFeelingList(AnnounceDataSource.GetFeelingListCallback callback);
    void postFeelingCommend();
    void postFeelingComment();
//    void postRequirementBook();
//    void postRequirementComment();

}
