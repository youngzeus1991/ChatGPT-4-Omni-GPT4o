package com.scut.itpm.umo.core.inform;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.scut.itpm.umo.R;

/**
 * Created by DELL on 2016/11/2.
 */

public class InformFragment extends Fragment implements InformContract.View{
    private ListView InformListView;
    private InformContract.Presenter informPresenter;
    //Context context;
    public static InformFragment newInstance(){ return new InformFragment(); }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_inform,container,false);
        return view;
    }

    @Override
    public void onResume() {
        Log.e("InformFragment:","onResume");
        super.onResume();
        informPresenter.onStart();
    }

    @Override
    public void showInformList(){

    }

    //set and get function is here
    @Override
    public void setPresenter(Object presenter){
       this.informPresenter=(InformPresenter)presenter;
    }
    @Override
    public void setInformListView(){
        this.InformListView=(ListView) this.getView().findViewById(R.id.InformListView);
    }
    @Override
    public ListView getInformListView(){
        setInformListView();
        return InformListView;
    }

    @Override
    public Context getInformContext(){
        return getActivity();
    }


    @Override
    public InformDetail getInformDetail(){
        return  new InformDetail();
    }
}
