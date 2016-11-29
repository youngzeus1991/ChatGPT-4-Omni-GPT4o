package com.scut.itpm.umo.core.Main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.scut.itpm.umo.BaseActivity;
import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.Main.Nav.NavBarController;
import com.scut.itpm.umo.core.Main.Nav.NavBarView;
import com.scut.itpm.umo.core.announce.AnnounceFragment;
import com.scut.itpm.umo.core.contact.ContactFragment;
import com.scut.itpm.umo.core.follow.FollowFragment;
import com.scut.itpm.umo.core.inform.InformFragment;
import com.scut.itpm.umo.core.message.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MainControllerListener {


    private MainView mainView;
    private NavBarView navBarView;
    private ViewPager viewPager;

    private MainController mainController;

    private List<Fragment> fragments = new ArrayList<>();

    private MessageFragment messageFragment;
    private ContactFragment contactFragment;
    private AnnounceFragment announceFragment;
    private FollowFragment followFragment;
    private InformFragment informFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView=(MainView) findViewById(R.id.activity_main);
        navBarView = (NavBarView) findViewById(R.id.id_main_nav_bar);
        viewPager=(ViewPager) findViewById(R.id.id_main_view_pager);



        initFragment();
        initViewPager();
        initController();

        mainController.start();


    }
    private void initFragment(){
        messageFragment = MessageFragment.newInstance();
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
    private void initViewPager(){
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }



    private void initController() {

        NavBarController navBarController = new NavBarController( navBarView);

        mainController=new MainController(mainView, navBarController);
        mainView.setListener(mainController);

    }
}
