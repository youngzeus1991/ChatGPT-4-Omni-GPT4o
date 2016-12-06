package com.scut.itpm.umo.data.inform.remote;

import android.content.Context;

/**
 * Created by dream on 2016/11/30.
 */

public class InformRemoteDataSource {
    private static InformRemoteDataSource informRemoteDataSource=null;
    public static InformRemoteDataSource getRemoteINSTACE(Context context){
        if (informRemoteDataSource!=null){
            return informRemoteDataSource;
        }else{
            return new InformRemoteDataSource();
        }
    }

}
