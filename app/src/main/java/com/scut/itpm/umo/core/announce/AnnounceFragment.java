package com.scut.itpm.umo.core.announce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.announce.map.MapFragment;
import com.scut.itpm.umo.core.announce.map.MapPresenter;
import com.scut.itpm.umo.core.announce.sociaty.Feeling.FeelingFragment;
import com.scut.itpm.umo.core.announce.sociaty.Feeling.FeelingPresenter;
import com.scut.itpm.umo.core.announce.sociaty.Requirement.RequirementFragment;
import com.scut.itpm.umo.core.announce.sociaty.Requirement.RequirementPresenter;
import com.scut.itpm.umo.util.RepositoryUtil;

/**
 * Created by DELL on 11/02.
 */

public class AnnounceFragment extends Fragment implements AnnounceContract.View {
    private boolean isFirstLoad;
    private AnnounceContract.Presenter announcePresenter;
    private  MapFragment mapFragment;
    private  FeelingFragment feelingFragment;
    private  RequirementFragment requirementFragment;


    public AnnounceFragment() {
        this.isFirstLoad=true;
    }

    public static AnnounceFragment newInstance() {
        return new AnnounceFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO 这里改变Layout配置文件，自定义界面
        View view = inflater.inflate(R.layout.fragment_announce, null);
        if(savedInstanceState==null) {
            mapFragment = MapFragment.newInstance();
            feelingFragment = FeelingFragment.newInstance();
            requirementFragment = RequirementFragment.newInstance();

            new MapPresenter(mapFragment, RepositoryUtil.getAnnounceRepository(getContext()));
            new FeelingPresenter(feelingFragment, RepositoryUtil.getAnnounceRepository(getContext()));
            new RequirementPresenter(requirementFragment, RepositoryUtil.getAnnounceRepository(getContext()));
        }
        else {
            FragmentManager fragmentManager=getChildFragmentManager();
            mapFragment= (MapFragment) fragmentManager.getFragment(savedInstanceState,"map");
            requirementFragment= (RequirementFragment) fragmentManager.getFragment(savedInstanceState,"requirement");
            feelingFragment= (FeelingFragment) fragmentManager.getFragment(savedInstanceState,"feeling");

            new MapPresenter(mapFragment, RepositoryUtil.getAnnounceRepository(getContext()));
            new FeelingPresenter(feelingFragment, RepositoryUtil.getAnnounceRepository(getContext()));
            new RequirementPresenter(requirementFragment, RepositoryUtil.getAnnounceRepository(getContext()));
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        announcePresenter.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        FragmentManager fragmentManager=getChildFragmentManager();
        fragmentManager.putFragment(outState,"map",mapFragment);
        fragmentManager.putFragment(outState,"requirement",requirementFragment);
        fragmentManager.putFragment(outState,"feeling",feelingFragment);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        Log.e("AnnounceFragment:", "onResume");
        super.onResume();
    }

    @Override
    public void setPresenter(Object presenter) {
        this.announcePresenter = (AnnounceContract.Presenter) presenter;
    }


    @Override
    public void setDefaultFragment() {
        //第一次加载，初始化3个Fragment，展示地图
        if(isFirstLoad==true) {
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.id_announce_LL, mapFragment, "map")
                    .add(R.id.id_announce_LL, requirementFragment, "requirement")
                    .add(R.id.id_announce_LL, feelingFragment, "feeling")
                    .commit();
            isFirstLoad=false;
            showMapFragment();
        }
        //非首次加载时，把回退栈里的顶部项取出，还原状态
        else{
            getChildFragmentManager().getBackStackEntryAt(getChildFragmentManager().getBackStackEntryCount()-1);
        }
    }

//TODO 这里Fragment的事务性逻辑需要优化
    @Override
    public void showMapFragment() {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.hide(mapFragment)
                .hide(requirementFragment)
                .hide(feelingFragment)
                .show(mapFragment).addToBackStack(null).commit();
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.id_announce_LL,fragments.get(MAP_FRAGMENT)).commit();
    }

    @Override
    public void showFeelingFragment() {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.hide(mapFragment)
                .hide(requirementFragment)
                .hide(feelingFragment)
                .show(feelingFragment).addToBackStack(null).commit();//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.id_announce_LL,fragments.get(FEELING_FRAGMENT)).commit();
    }

    @Override
    public void showRequirementFragment() {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.hide(mapFragment)
                .hide(requirementFragment)
                .hide(feelingFragment)
                .show(requirementFragment).addToBackStack(null).commit();//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.id_announce_LL,fragments.get(FEELING_FRAGMENT)).commit();
    }
}
