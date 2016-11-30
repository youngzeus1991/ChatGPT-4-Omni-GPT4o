package com.scut.itpm.umo.core.announce;

import com.scut.itpm.umo.data.announce.AnnounceDataSource;
import com.scut.itpm.umo.data.announce.AnnounceModel;
import com.scut.itpm.umo.data.announce.AnnounceRepository;

import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public class AnnouncePresenter implements AnnounceContract.Presenter {
    private AnnounceContract.View announceView;
    private AnnounceRepository announceRepository;

    public AnnouncePresenter(AnnounceContract.View announceView, AnnounceRepository announceRepository) {
        this.announceView = announceView;
        this.announceRepository = announceRepository;
        this.announceView.setPresenter(this);
    }

    @Override
    public void start() {
        //TODO 这里进行界面初始化的一些操作
        fetchAnnounceList();

    }

    @Override
    public void fetchAnnounceList() {
        announceRepository.getAnnounceList(new AnnounceDataSource.GetAnnounceListCallback() {
            //TODO 这里是获取数据后成功与否的回调方法
            @Override
            public void didGetAnnounceList(List<AnnounceModel> announceModelList) {
                announceView.showAnnounceList(announceModelList);
            }

            @Override
            public void announceListNotAvailable() {

                announceView.showNoAnnounceList();

            }
        });

    }
}
