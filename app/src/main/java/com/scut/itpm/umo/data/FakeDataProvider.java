package com.scut.itpm.umo.data;

import android.util.Log;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.inform.InformConstName;
import com.scut.itpm.umo.data.announce.AnnounceModel;
import com.scut.itpm.umo.data.inform.InformModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/11/30.
 */

public class FakeDataProvider {
    //TODO 获取假数据的地方
    public static List<AnnounceModel>  getAnnounceList(){
        List<AnnounceModel> announceModelList=new ArrayList<>();
        return announceModelList;
    }

   public static List<InformModel> getInformList(){
        List<InformModel>SampleInformList=new ArrayList<>();

      InformModel sampleInformModel= new InformModel("土豪","一起来玩把");
       SampleInformList.add(sampleInformModel);

       sampleInformModel=new InformModel("小冰","预约了你的需求");
       SampleInformList.add(sampleInformModel);

       sampleInformModel=new InformModel("小贤","发布了新的动态");
       SampleInformList.add(sampleInformModel);

        return SampleInformList;
    }
}
