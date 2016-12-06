package com.scut.itpm.umo.data.inform;

import android.content.Context;

import com.scut.itpm.umo.data.inform.local.InformLocalDataSource;
import com.scut.itpm.umo.data.inform.remote.InformRemoteDataSource;

import java.util.ArrayList;

/**
 * Created by dream on 2016/11/30.
 */

public class InformRepository implements  InformDataSource{
    private  static InformRepository InformRepositoryINSTANCE=null;
    private InformLocalDataSource InformLocalDataSource;
    private InformRemoteDataSource InformRemoteDataSource;
    private static Context context;

    //initialize the InformRepository
    public InformRepository(Context context,InformLocalDataSource informLocalDataSource,InformRemoteDataSource informRemoteDataSource){
        InformRepository.context=context;
        this.InformLocalDataSource= informLocalDataSource;
        this.InformRemoteDataSource= informRemoteDataSource;
    }

    public static InformRepository getInstance(Context context,InformLocalDataSource informLocalDataSource,InformRemoteDataSource informRemoteDataSource){
        if(InformRepositoryINSTANCE!=null){
            return InformRepositoryINSTANCE;
        }else{
            return new InformRepository(context,informLocalDataSource,informRemoteDataSource);
        }
    }
@Override
    public ArrayList<InformModel> getInformList(final GetInformListCallback callback) {
        //Todo 无网络状态下
        if (!InformModel.isNetworkConnected(context)) {
            return InformLocalDataSource.getInformList(callback);
        } else {
            //Todo get data from webserver
            return InformLocalDataSource.getInformList(callback);
        }
    }
}
