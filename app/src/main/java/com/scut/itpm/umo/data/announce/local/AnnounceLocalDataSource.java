package com.scut.itpm.umo.data.announce.local;

import android.content.Context;

import com.scut.itpm.umo.data.FakeDataProvider;
import com.scut.itpm.umo.data.announce.AnnounceDataSource;
import com.scut.itpm.umo.data.announce.FeelingModel;
import com.scut.itpm.umo.data.announce.RequirementModel;
import com.scut.itpm.umo.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/11/30.
 */

public class AnnounceLocalDataSource implements AnnounceDataSource {
    private static AnnounceLocalDataSource INSTANCE;
    public static AnnounceLocalDataSource getInstance(Context context){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        else{
            return new AnnounceLocalDataSource(context);
        }
    }
    public AnnounceLocalDataSource(Context context) {
        //TODO context之后会在数据库存储时使用到
    }



    @Override
    public void getFeelingList(GetFeelingListCallback callback) {
            //TODO 这里进行假数据或者数据库读取
        List<FeelingModel> feelingModelList =new ArrayList<>();

        if(Constant.isFakeDataDebug){
            feelingModelList = FakeDataProvider.getFeelingList();
        }
        else{
            //TODO 进行数据库读取
        }

        if(feelingModelList !=null&& feelingModelList.size()>0){
            callback.didGetFeelingList(feelingModelList);
        }
        else{
            callback.feelingListNotAvailable();
        }
    }

    @Override
    public void getRequirementList(GetRequirementListCallback callback) {
        List<RequirementModel> requirementModelList =new ArrayList<>();

        if(Constant.isFakeDataDebug){
            requirementModelList = FakeDataProvider.getRequirementList();
        }
        else{
            // 进行数据库读取
        }

        if(requirementModelList !=null&& requirementModelList.size()>0){
            callback.didGetRequirementList(requirementModelList);
        }
        else{
            callback.requirementListNotAvailable();
        }
    }

    @Override
    public void getFeelingDetail(int ID, GetFeelingDetailCallback callback) {

    }

    @Override
    public void getRequirementDetail(int ID, GetRequirementDetailCallback callback) {

    }
}
