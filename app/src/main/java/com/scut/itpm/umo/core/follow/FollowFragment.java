package com.scut.itpm.umo.core.follow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.announce.sociaty.Feeling.FeelingDetail.FeelingDetailActivity;
import com.scut.itpm.umo.core.announce.sociaty.Requirement.RequirementDetail.RequirementDetailActivity;
import com.scut.itpm.umo.data.announce.FeelingModel;
import com.scut.itpm.umo.data.announce.RequirementModel;
import com.scut.itpm.umo.data.follow.FollowModel;

import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public class FollowFragment extends Fragment implements FollowContract.View{
    private FollowContract.Presenter followPresenter;

    private ListView followListView;
    public static FollowFragment newInstance(){
        return new FollowFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View followView= inflater.inflate(R.layout.fragment_follow,null);
        followListView= (ListView) followView.findViewById(R.id.id_follow_list_view);

        return followView;
    }
    @Override
    public void onResume() {
        Log.e("FollowFragment:","onResume");
        super.onResume();
        followPresenter.start();
    }

    @Override
    public void showFollowList(List<FollowModel> followList) {
        FollowListAdapter adapter=new FollowListAdapter(getContext(),followList,this);
        followListView.setAdapter(adapter);
        followListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showFollowDetail((FollowModel) adapterView.getItemAtPosition(i));
            }
        });
    }

    @Override
    public void showNoFollowList() {

    }

    @Override
    public void showFollowDetail(FollowModel followModel) {
        if(followModel instanceof FeelingModel){
            Intent intent=new Intent(getActivity(), FeelingDetailActivity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("feelingModel",(FeelingModel)followModel);
            intent.putExtra("bundleFeelingModel",bundle);
            startActivity(intent);
        }
        if(followModel instanceof RequirementModel){
            Intent intent=new Intent(getActivity(), RequirementDetailActivity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("requirementModel",(RequirementModel)followModel);
            intent.putExtra("bundleRequirementModel",bundle);
            startActivity(intent);
        }
    }

    @Override
    public void showNoFollowDetail() {

    }

    @Override
    public void setPresenter(Object presenter) {
        this.followPresenter= (FollowContract.Presenter) presenter;
    }

    @Override
    public void onClick(View view) {

    }
}
