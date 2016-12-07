package com.scut.itpm.umo.data.inform.local;

import android.content.Context;
import android.util.Log;

import com.scut.itpm.umo.data.FakeDataProvider;
import com.scut.itpm.umo.data.inform.InformDataSource;
import com.scut.itpm.umo.data.inform.InformModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 2016/11/30.
 */

public class InformLocalDataSource implements InformDataSource{
    private static  InformLocalDataSource localINSTANCE=null;
    final static List<InformModel>SampleInformList= FakeDataProvider.getInformList();
    List<InformModel>InformList=new ArrayList<>();

    //construct function
  private   InformLocalDataSource(Context context){
      InformList=SampleInformList;
    }

    //function to get a instance
    public static InformLocalDataSource getLocalINSTANCE(Context context){
        if(localINSTANCE==null){
            return new InformLocalDataSource(context);
        }else{
            return localINSTANCE;
        }
    }

    //function to get  InformList
    public ArrayList<InformModel> getInformList(GetInformListCallback callback){
        if(InformList!=null&&InformList.size()>0){
           return callback.didGetInformList(InformList);
        }else{
            callback.InformListNotAvilable();
            return null;
        }
    }
}