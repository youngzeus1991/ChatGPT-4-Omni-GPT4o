package com.scut.itpm.umo.core.announce.map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scut.itpm.umo.R;

/**
 * Created by DELL on 2016/12/2.
 */

public class MapFragment extends Fragment implements MapContract.View{
    private static  MapFragment INSTANCE;
    private MapContract.Presenter mapPresenter;
    public static MapFragment newInstance() {
        if(INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new MapFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mapView=inflater.inflate(R.layout.fragment_map,null);
        return mapView;
    }

    @Override
    public void setPresenter(Object presenter) {
        mapPresenter= (MapContract.Presenter) presenter;
    }
}
