package com.scut.itpm.umo.data.inform;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.MediaStore;


import com.scut.itpm.umo.R;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static com.scut.itpm.umo.R.drawable.main_tab_bar_contacts;


/**
 * Created by dream on 2016/11/30.
 */

public class InformModel {
    //Time operation
    class InformTime{
        private Calendar InformTime;
        public InformTime(){ setInformTime(); }

        //set and get function
        public Calendar getInformTime(){ return InformTime;}
        private void setInformTime(){
            this.InformTime=Calendar.getInstance();
        }
        public int getTimeDifference(){
            int differenceTime=0;
            Calendar SystemTime=Calendar.getInstance();
            int tempInformTime=this.InformTime.get(Calendar.DAY_OF_MONTH)*24*60*60*1000+this.InformTime.get(Calendar.HOUR)*60*60*1000+this.InformTime.get(Calendar.MINUTE)*60*1000+this.InformTime.get(Calendar.SECOND)*1000;
            int tempSystemTime=SystemTime.get(Calendar.DAY_OF_MONTH)*24*60*60*1000+SystemTime.get(Calendar.HOUR)*60*60*1000+SystemTime.get(Calendar.MINUTE)*60*1000+SystemTime.get(Calendar.SECOND)*1000;
            int tempDifferenceTime=tempSystemTime-tempInformTime;
            differenceTime=(tempDifferenceTime/1000)/60;
            return differenceTime;
        }
        public String getInformDetailTime(){
            return InformTime.get(Calendar.YEAR)+"年"+InformTime.get(Calendar.MONTH)
                    +"月"+InformTime.get(Calendar.DAY_OF_MONTH)
                    +"日"+InformTime.get(Calendar.HOUR)
                    +": "+InformTime.get(Calendar.MINUTE);
        }
    }

    //Image operation
    class InformImage{
        private int UserImageID;
        public InformImage(){

        }
        public int getUserImageID(){return UserImageID;}
        public void setUserImageID(int imageID){
           UserImageID=imageID;
        }

    }

    private int UserID;
    private String userName;
    private String  InformMessage;
    private InformTime InformTime;
    private InformImage InformImage;

    //construct function
   public InformModel(String userName,String InformMessage){
        setUserName(userName);
        setInformMessage(InformMessage);
        InformImage=new InformImage();
        InformTime=new InformTime();
    }

    //set and get function
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getInformMessage() { return InformMessage; }
    public void setInformMessage(String informMessage) { this.InformMessage = informMessage; }

    public int getInformTimeDifference(){
        return this.InformTime.getTimeDifference();
    }
    public String getInformDetailTime(){return this.InformTime.getInformDetailTime();}

    public int getInformImageID(){ return  this.InformImage.getUserImageID();}
    public void setInformImageID(int imageID){ this.InformImage.setUserImageID(imageID);}
    //charge network
    public static boolean isNetworkConnected(Context context){
        if(context!=null){
            ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }


}


