package com.scut.itpm.umo.core.announce.map;

import com.scut.itpm.umo.data.announce.AnnounceRepository;

/**
 * Created by DELL on 2016/12/2.
 */

public class MapPresenter implements MapContract.Presenter {
    private MapContract.View mapView;
    private AnnounceRepository announceRepository;
    public MapPresenter(MapContract.View view, AnnounceRepository announceRepository) {
        this.mapView=view;
        this.announceRepository=announceRepository;
        this.mapView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
