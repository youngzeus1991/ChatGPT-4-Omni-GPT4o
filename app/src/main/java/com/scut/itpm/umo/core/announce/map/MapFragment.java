package com.scut.itpm.umo.core.announce.map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ZoomControls;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
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
    private  MapView mMapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mapView=inflater.inflate(R.layout.fragment_map,null);
        mMapView= (MapView) mapView.findViewById(R.id.bmapView);
        mMapView.showZoomControls(false);

        mMapView.removeViewAt(1);
        return mapView;
    }

    public void hideZoomControls()
    {
        int childCount = mMapView.getChildCount();
        View zoom = null;
        for (int i = 0; i < childCount; i++) {
            View child = mMapView.getChildAt(i);
            if (child instanceof ZoomControls) {
                zoom = child;
                break;
            }
        }
        zoom.setVisibility(View.GONE);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void setPresenter(Object presenter) {
        mapPresenter= (MapContract.Presenter) presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
