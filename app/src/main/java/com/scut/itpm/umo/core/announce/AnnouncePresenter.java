package com.scut.itpm.umo.core.announce;

import com.scut.itpm.umo.core.announce.map.MapContract;
import com.scut.itpm.umo.core.announce.sociaty.Feeling.FeelingContract;
import com.scut.itpm.umo.core.announce.sociaty.Requirement.RequirementContract;
import com.scut.itpm.umo.data.announce.AnnounceRepository;


/**
 * Created by DELL on 2016/11/2.
 */

public class AnnouncePresenter implements AnnounceContract.Presenter {
    private AnnounceContract.View announceView;
    private AnnounceRepository announceRepository;

    private MapContract.Presenter mapPresenter;
    private FeelingContract.Presenter feelingPresenter;
    private RequirementContract.Presenter requirementPresenter;

    public AnnouncePresenter(AnnounceContract.View announceView, AnnounceRepository announceRepository) {

        this.announceRepository = announceRepository;
        this.announceView = announceView;
        this.announceView.setPresenter(this);

    }

    @Override
    public void start() {
        //TODO 这里进行界面初始化的一些操作

        announceView.setDefaultFragment();
    }

    @Override
    public void informMapFragmentShouldShow() {
        announceView.showMapFragment();
    }

    @Override
    public void informFeelingFragmentShouldShow() {
        announceView.showFeelingFragment();
    }

    @Override
    public void informRequirementFragmentShouldShow() {
        announceView.showRequirementFragment();
    }



}
