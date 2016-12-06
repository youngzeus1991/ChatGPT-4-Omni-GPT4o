package com.scut.itpm.umo.core.inform;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.inform.InformDataSource;
import com.scut.itpm.umo.data.inform.InformModel;
import com.scut.itpm.umo.data.inform.InformRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/11/2.
 */

public class InformPresenter implements  InformContract.Presenter{
    private static SimpleAdapter InformViewAdapter;
    //bind informRepository and fragment
    private  InformRepository InformRepository;
    private  InformContract.View InformFragmentView;
    private  Context context;
    final ArrayList<InformModel> informList;
    //variables for handle the informdetail
    private InformDetail informDetail;
    //fragment manage
    private android.support.v4.app.FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    //construct function
   public InformPresenter(InformContract.View informFragmentView, InformRepository informRepository){
       this.InformFragmentView=informFragmentView;
       this.InformRepository=informRepository;
       this.InformFragmentView.setPresenter(this);
       informList = InformRepository.getInformList(new InformDataSource.GetInformListCallback() {
           @Override
           public ArrayList<InformModel> didGetInformList(List<InformModel> InformList) {
               Log.d("InformList size is", "" + InformList.size());
               return (ArrayList<InformModel>) InformList;
           }
           @Override
           public void InformListNotAvilable() {
               Log.e("InformList ", "is not avaliable！");
               System.out.print("Sorry ,but the InformLsit is not avaliable now!");
           }
       });
    }

    private void initializeAdapter(){
        InformViewAdapter=new SimpleAdapter(context, this.getData(),R.layout.fragment_inform_listview,
                new String[]{InformConstName.inform_data_userName,
                        InformConstName.inform_data_message,
                        InformConstName.inform_data_time,
                        InformConstName.inform_data_imageID},
                new int[]{R.id.UserName,R.id.message,R.id.InformTime,R.id.UserImage});
    }


    //set and get fucntion
    private ArrayList<Map<String,Object>>getData(){
        ArrayList<Map<String,Object>> List= new ArrayList<Map<String, Object>>();
        Map<String,Object>map;
        for(int i=0;i<informList.size();i++) {
            map=new HashMap<String, Object>();
            map.put(InformConstName.inform_data_userName,informList.get(i).getUserName() );
            Log.d(InformConstName.inform_data_userName,informList.get(i).getUserName());

            map.put(InformConstName.inform_data_message,informList.get(i).getInformMessage());
            Log.d(InformConstName.inform_data_message,informList.get(i).getInformMessage());

            map.put(InformConstName.inform_data_time,informList.get(i).getInformTimeDifference()+"分钟前");
            Log.d(InformConstName.inform_data_time,informList.get(i).getInformTimeDifference()+"分钟前");

            map.put(InformConstName.inform_data_imageID,R.drawable.simple_01);
            Log.d(InformConstName.inform_data_imageID,R.drawable.simple_01+"");

            List.add(map);
        }
        return List;
    }

    @Override
    public  void onStart(){
        context=InformFragmentView.getInformContext();
        initializeAdapter();
        InformFragmentView.getInformListView().setAdapter(InformViewAdapter);
        clickItem();
    }

    // handle th click  event
    private void clickItem(){
        informDetail=InformFragmentView.getInformDetail();
        informDetail.setPresenter(this);
        InformFragmentView.getInformListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt(InformConstName.inform_detail_image,R.drawable.simple_01);
                bundle.putString(InformConstName.inform_detail_userName, informList.get(position).getUserName());
                bundle.putString(InformConstName.inform_detail_message, informList.get(position).getInformMessage());
                bundle.putInt(InformConstName.inform_detail_timeDifference, informList.get(position).getInformTimeDifference());
                Intent intent=new Intent(InformFragmentView.getInformContext(),InformDetail.class);
                intent.putExtra(InformConstName.inform_detail_bundle_name,bundle);
                InformFragmentView.getInformContext().startActivity(intent);
            }
        });
    }
}



































