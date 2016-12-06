package com.scut.itpm.umo.core.announce.sociaty.Feeling;

import com.scut.itpm.umo.data.announce.AnnounceDataSource;
import com.scut.itpm.umo.data.announce.AnnounceRepository;
import com.scut.itpm.umo.data.announce.FeelingModel;

import java.util.List;

/**
 * Created by DELL on 2016/12/2.
 */

public class FeelingPresenter implements FeelingContract.Presenter{
    private FeelingContract.View feelingView;
    private AnnounceRepository announceRepository;
    public FeelingPresenter(FeelingContract.View feelingView, AnnounceRepository announceRepository) {
        this.feelingView=feelingView;
        this.announceRepository=announceRepository;
        this.feelingView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchFeelingList();
    }

    @Override
    public void fetchFeelingList() {
        announceRepository.getFeelingList(new AnnounceDataSource.GetFeelingListCallback() {
            @Override
            public void didGetFeelingList(List<FeelingModel> feelingModelList) {
                feelingView.showFeelingList(feelingModelList);
            }

            @Override
            public void feelingListNotAvailable() {
                feelingView.showNoFeelingList();
            }
        });

    }

    @Override
    public void fetchFeelingDetail(int ID) {

    }
}
