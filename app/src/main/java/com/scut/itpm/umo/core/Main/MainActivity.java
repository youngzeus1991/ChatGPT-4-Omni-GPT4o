package com.scut.itpm.umo.core.Main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.baidu.mapapi.SDKInitializer;
import com.scut.itpm.umo.BaseActivity;
import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.Main.Main.MainContract;
import com.scut.itpm.umo.core.Main.Main.MainFragmentAdapter;
import com.scut.itpm.umo.core.Main.Main.MainPresenter;
import com.scut.itpm.umo.core.Main.Main.MainView;
import com.scut.itpm.umo.core.Main.NavBar.NavBarContract;
import com.scut.itpm.umo.core.Main.NavBar.NavBarPresenter;
import com.scut.itpm.umo.core.Main.NavBar.NavBarView;
import com.scut.itpm.umo.core.announce.AnnounceContract;
import com.scut.itpm.umo.core.announce.AnnounceFragment;
import com.scut.itpm.umo.core.announce.AnnouncePresenter;
import com.scut.itpm.umo.core.contact.ContactFragment;
import com.scut.itpm.umo.core.follow.FollowFragment;
import com.scut.itpm.umo.core.follow.FollowPresenter;
import com.scut.itpm.umo.core.inform.InformFragment;
import com.scut.itpm.umo.core.inform.InformPresenter;
import com.scut.itpm.umo.core.message.MessageFragment;
import com.scut.itpm.umo.core.message.MessagePresenter;
import com.scut.itpm.umo.util.RepositoryUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private MainView mainView;
    private NavBarView navBarView;
    private ViewPager viewPager;

    private MainContract.Presenter mainPresenter;
    private NavBarContract.Presenter navBarPresenter;
    private AnnounceContract.Presenter announcePresenter;

    private List<Fragment> fragments = new ArrayList<>();

    private MessageFragment messageFragment;
    private ContactFragment contactFragment;
    private AnnounceFragment announceFragment;
    private FollowFragment followFragment;
    private InformFragment informFragment;

    //耀友增加
    private MessagePresenter mesPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainView = (MainView) findViewById(R.id.id_main_main);
        navBarView = (NavBarView) findViewById(R.id.id_main_nav_bar);
        viewPager = (ViewPager) mainView.findViewById(R.id.id_main_view_pager);

        initFragment();
        initViewPager();
        initPresenter();
        initListener();

        mainPresenter.start();

    }


    private void initFragment() {
        messageFragment = MessageFragment.newInstance(this);
        contactFragment = ContactFragment.newInstance();
        announceFragment = AnnounceFragment.newInstance();
        followFragment = FollowFragment.newInstance();
        informFragment = InformFragment.newInstance();

        fragments.add(messageFragment);
        fragments.add(contactFragment);
        fragments.add(announceFragment);
        fragments.add(followFragment);
        fragments.add(informFragment);

    }

    private void initViewPager() {
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    private void initPresenter() {

        navBarPresenter = new NavBarPresenter(navBarView, new Connector.CallbackOnNavBar() {

            @Override
            public void mapFragmentShouldShow() {
                announcePresenter.informMapFragmentShouldShow();
            }

            @Override
            public void feelingFragmentShouldShow() {
                announcePresenter.informFeelingFragmentShouldShow();
            }

            @Override
            public void requirementFragmentShouldShow() {
                announcePresenter.informRequirementFragmentShouldShow();
            }
        });
        mainPresenter = new MainPresenter(mainView, new Connector.CallbackOnMainView() {
            @Override
            public void navBarTitleShouldChange(String titleToBe) {
                navBarPresenter.setCurrentTitle(titleToBe);
            }
        });

        //TODO 此处初始化Presenter，并绑定View和Repository（本地和远程数据源由Repository统一管理）
        announcePresenter = new AnnouncePresenter(announceFragment, RepositoryUtil.getAnnounceRepository(this));
        new AnnouncePresenter(announceFragment, RepositoryUtil.getAnnounceRepository(this));

        new InformPresenter(informFragment,RepositoryUtil.getInformRepository(this));

        mesPresenter = new MessagePresenter(messageFragment,RepositoryUtil.getMessageRepository(this));
        new FollowPresenter(RepositoryUtil.getFollowRepository(this),followFragment);

    }


    private void initListener() {
        mainView.setListener((MainPresenter) mainPresenter);
    }
}
