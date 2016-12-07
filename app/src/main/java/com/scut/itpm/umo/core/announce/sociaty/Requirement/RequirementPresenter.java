package com.scut.itpm.umo.core.announce.sociaty.Requirement;

import com.scut.itpm.umo.data.announce.AnnounceDataSource;
import com.scut.itpm.umo.data.announce.AnnounceRepository;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.util.List;

/**
 * Created by DELL on 2016/12/2.
 */

public class RequirementPresenter implements RequirementContract.Presenter {
    private RequirementContract.View requirementView;
    private AnnounceRepository announceRepository;
    public RequirementPresenter(RequirementContract.View requirementView, AnnounceRepository announceRepository) {
        this.requirementView=requirementView;
        this.announceRepository=announceRepository;
        this.requirementView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchRequirementList();
    }

    @Override
    public void fetchRequirementList() {
        announceRepository.getRequirementList(new AnnounceDataSource.GetRequirementListCallback() {
            @Override
            public void didGetRequirementList(List<RequirementModel> requirementModelList) {
                requirementView.showRequirementList(requirementModelList);
            }

            @Override
            public void requirementListNotAvailable() {
                requirementView.showNoRequirementList();
            }
        });
    }

    @Override
    public void fetchRequirementDetail(int ID) {

    }
}
