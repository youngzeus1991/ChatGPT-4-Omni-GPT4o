package com.scut.itpm.umo.data.announce.local;

import android.content.Context;

import com.scut.itpm.umo.data.FakeDataProvider;
import com.scut.itpm.umo.data.announce.AnnounceDataSource;
import com.scut.itpm.umo.data.announce.AnnounceModel;
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
    public void getAnnounceList(GetAnnounceListCallback callback) {
            //TODO 这里进行假数据或者数据库读取
        List<AnnounceModel> announceModelList=new ArrayList<>();

        if(Constant.isFakeDataDebug){
            announceModelList= FakeDataProvider.getAnnounceList();
        }
        else{
            //TODO 进行数据库读取
        }

        if(announceModelList!=null&&announceModelList.size()>0){
            callback.didGetAnnounceList(announceModelList);
        }
        else{
            callback.announceListNotAvailable();
        }
    }
}
