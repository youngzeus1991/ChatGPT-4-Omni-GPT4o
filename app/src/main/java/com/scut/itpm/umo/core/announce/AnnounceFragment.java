package com.scut.itpm.umo.core.announce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.announce.AnnounceModel;

import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public class AnnounceFragment extends Fragment implements AnnounceContract.View {
    private AnnounceContract.Presenter announcePresenter;
    public static AnnounceFragment newInstance(){
        return new AnnounceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO 这里改变Layout配置文件，自定义界面
        View view=inflater.inflate(R.layout.fragment_announce,null);
        return view;
    }

    @Override
    public void onResume() {
        Log.e("AnnounceFragment:","onResume");
        super.onResume();
        announcePresenter.start();
    }

    @Override
    public void setPresenter(Object presenter) {
        this.announcePresenter=(AnnounceContract.Presenter)presenter;
    }

    @Override
    public void showAnnounceList(List<AnnounceModel> announceModelList) {
        //TODO 这里界面展示数据

    }

    @Override
    public void showNoAnnounceList() {
        //TODO 这里界面展示未获得数据时的提示
    }
}
