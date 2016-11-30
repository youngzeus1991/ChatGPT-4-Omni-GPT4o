package com.scut.itpm.umo.data.announce;

import java.util.List;

/**
 * Created by DELL on 2016/11/30.
 */

public interface AnnounceDataSource {
    //TODO 这里是回调接口

    interface GetAnnounceListCallback{

        void didGetAnnounceList(List<AnnounceModel>announceModelList);

        void announceListNotAvailable();
    }


    //TODO 这里是定义数据源的行为职责
    void getAnnounceList(GetAnnounceListCallback callback);

}
