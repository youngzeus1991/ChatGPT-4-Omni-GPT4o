package com.scut.itpm.umo.data.announce.remote;

import android.content.Context;

import com.scut.itpm.umo.data.announce.AnnounceDataSource;

/**
 * Created by DELL on 2016/11/30.
 */

public class AnnounceRemoteDataSource implements AnnounceDataSource{
    private static AnnounceRemoteDataSource INSTANCE;
    public static AnnounceRemoteDataSource getInstance(Context context){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        else{
            return new AnnounceRemoteDataSource(context);
        }
    }
    public AnnounceRemoteDataSource(Context context) {
    }


    @Override
    public void getFeelingList(GetFeelingListCallback callback) {

    }

    @Override
    public void getRequirementList(GetRequirementListCallback callback) {

    }

    @Override
    public void getFeelingDetail(int ID, GetFeelingDetailCallback callback) {

    }

    @Override
    public void getRequirementDetail(int ID, GetRequirementDetailCallback callback) {

    }
}
