package com.scut.itpm.umo.data.announce;

import android.content.Context;

import java.util.List;

/**
 * Created by DELL on 2016/11/30.
 */

public class AnnounceRepository implements AnnounceDataSource {
    private static AnnounceRepository INSTANCE;
    private AnnounceDataSource announceLocalDataSource;
    private AnnounceDataSource announceRemoteDataSource;

    public static AnnounceRepository getInstance(Context context,AnnounceDataSource announceLocalDataSource,AnnounceDataSource announceRemoteDataSource){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        else {
            return new AnnounceRepository(announceLocalDataSource, announceRemoteDataSource);
        }
    }

    public AnnounceRepository(AnnounceDataSource announceLocalDataSource,AnnounceDataSource announceRemoteDataSource) {
        this.announceLocalDataSource=announceLocalDataSource;
        this.announceRemoteDataSource=announceRemoteDataSource;
    }


    @Override
    public void getAnnounceList(final GetAnnounceListCallback callback) {
        //TODO 无网络情况下的调取本地数据
        announceLocalDataSource.getAnnounceList(callback);

        //TODO 一种本地获取失败后调取网络数据的方式
        announceLocalDataSource.getAnnounceList(new GetAnnounceListCallback() {
            @Override
            public void didGetAnnounceList(List<AnnounceModel> announceModelList) {
                callback.didGetAnnounceList(announceModelList);
            }

            @Override
            public void announceListNotAvailable() {
                announceRemoteDataSource.getAnnounceList(new GetAnnounceListCallback() {
                    @Override
                    public void didGetAnnounceList(List<AnnounceModel> announceModelList) {
                        callback.didGetAnnounceList(announceModelList);
                    }

                    @Override
                    public void announceListNotAvailable() {
                        callback.announceListNotAvailable();
                    }
                });
            }
        });
    }
}
