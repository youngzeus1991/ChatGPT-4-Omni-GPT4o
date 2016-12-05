package com.scut.itpm.umo.core.announce.sociaty.Requirement;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.util.List;

/**
 * Created by DELL on 2016/12/2.
 */

public class RequirementFragment extends Fragment implements RequirementContract.View {
    private ListView requirementListView;
    private RequirementContract.Presenter requirementPresenter;
    private static RequirementFragment INSTANCE;
    public static RequirementFragment newInstance(){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new RequirementFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View requirementView=inflater.inflate(R.layout.fragment_requirement,null);
        requirementListView= (ListView) requirementView.findViewById(R.id.id_fragment_requirement_list_view);
        return requirementView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        requirementPresenter.start();
    }

    @Override
    public void setPresenter(Object presenter) {
        this.requirementPresenter= (RequirementContract.Presenter) presenter;
    }

    @Override
    public void showRequirementList(final List<RequirementModel> requirementModelList) {
        RequirementListAdapter adapter=new RequirementListAdapter(getContext(),requirementModelList,this);
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                showRequirementList(requirementModelList);
            }
        });
        requirementListView.setAdapter(adapter);
    }

    @Override
    public void showNoRequirementList() {

    }

    @Override
    public void showRequirementDetail() {

    }

    @Override
    public void showNoRequirementDetail() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_requirement_book_button:
            case R.id.id_requirement_commend_button:
            case R.id.id_requirement_share_button:
        }
    }
}
