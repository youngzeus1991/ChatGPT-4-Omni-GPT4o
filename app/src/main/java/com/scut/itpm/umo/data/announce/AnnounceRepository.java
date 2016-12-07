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
            return INSTANCE=new AnnounceRepository(announceLocalDataSource, announceRemoteDataSource);
        }
    }

    public AnnounceRepository(AnnounceDataSource announceLocalDataSource,AnnounceDataSource announceRemoteDataSource) {
        this.announceLocalDataSource=announceLocalDataSource;
        this.announceRemoteDataSource=announceRemoteDataSource;
    }


    @Override
    public void getFeelingList(final GetFeelingListCallback callback) {
/*        //TODO 无网络情况下的调取本地数据
        announceLocalDataSource.getFeelingList(callback);*/

        //TODO 一种本地获取失败后调取网络数据的方式
        announceLocalDataSource.getFeelingList(new GetFeelingListCallback() {
            @Override
            public void didGetFeelingList(List<FeelingModel> feelingModelList) {
                callback.didGetFeelingList(feelingModelList);
            }

            @Override
            public void feelingListNotAvailable() {
                announceRemoteDataSource.getFeelingList(new GetFeelingListCallback() {
                    @Override
                    public void didGetFeelingList(List<FeelingModel> feelingModelList) {
                        callback.didGetFeelingList(feelingModelList);
                    }

                    @Override
                    public void feelingListNotAvailable() {
                        callback.feelingListNotAvailable();
                    }
                });
            }
        });
    }


    @Override
    public void getRequirementList(final GetRequirementListCallback callback) {
        announceLocalDataSource.getRequirementList(new GetRequirementListCallback() {
            @Override
            public void didGetRequirementList(List<RequirementModel> requirementModelList) {
                callback.didGetRequirementList(requirementModelList);
            }

            @Override
            public void requirementListNotAvailable() {
                announceRemoteDataSource.getRequirementList(new GetRequirementListCallback() {
                    @Override
                    public void didGetRequirementList(List<RequirementModel> requirementModelList) {
                        callback.didGetRequirementList(requirementModelList);
                    }

                    @Override
                    public void requirementListNotAvailable() {
                        callback.requirementListNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void getFeelingDetail(int ID, GetFeelingDetailCallback callback) {

    }

    @Override
    public void getRequirementDetail(int ID, GetRequirementDetailCallback callback) {

    }
}
