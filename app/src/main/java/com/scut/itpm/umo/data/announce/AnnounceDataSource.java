package com.scut.itpm.umo.data.announce;

import java.util.List;

/**
 * Created by DELL on 2016/11/30.
 */

public interface AnnounceDataSource {
    //TODO 这里是回调接口

    interface GetFeelingListCallback {

        void didGetFeelingList(List<FeelingModel> feelingModelList);

        void feelingListNotAvailable();
    }
    interface GetRequirementListCallback{
        void didGetRequirementList(List<RequirementModel> requirementModelList);
        void requirementListNotAvailable();
    }

    interface GetFeelingDetailCallback{
        void didGetFeelingDetail(FeelingModel feelingModel);
        void feelingDetailNotAvailable();
    }
    interface GetRequirementDetailCallback{
        void didGetRequirementDetail(FeelingModel feelingModel);
        void requirementDetailNotAvailable();
    }


    //TODO 这里是定义数据源的行为职责
    void getFeelingList(GetFeelingListCallback callback);

    void getRequirementList(GetRequirementListCallback callback);

    void getFeelingDetail(int ID, GetFeelingDetailCallback callback);

    void getRequirementDetail(int ID, GetRequirementDetailCallback callback);

}
