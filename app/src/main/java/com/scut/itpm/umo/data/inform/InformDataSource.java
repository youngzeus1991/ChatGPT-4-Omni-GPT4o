package com.scut.itpm.umo.data.inform;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 2016/11/30.
 */

public interface InformDataSource {
    interface GetInformListCallback{
        ArrayList<InformModel> didGetInformList(List<InformModel>InformList);
        void InformListNotAvilable();
    }

    ArrayList<InformModel> getInformList(GetInformListCallback callback);
}
