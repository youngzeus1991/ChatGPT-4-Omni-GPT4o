package com.scut.itpm.umo.core.announce.sociaty.Feeling;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.announce.FeelingModel;

import java.util.List;

/**
 * Created by DELL on 2016/12/2.
 */

public class FeelingFragment extends Fragment implements FeelingContract.View {
    private FeelingContract.Presenter feelingPresenter;

    private ListView feelingListView;
    private static FeelingFragment INSTANCE;
    public static FeelingFragment newInstance(){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new FeelingFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mapView=inflater.inflate(R.layout.fragment_feeling,null);
        feelingListView= (ListView) mapView.findViewById(R.id.id_fragment_feeling_list_view);
        return mapView;
    }

    @Override
    public void onResume() {
        super.onResume();
        feelingPresenter.start();
    }

    @Override
    public void setPresenter(Object presenter) {
        feelingPresenter= (FeelingContract.Presenter) presenter;
    }

    @Override
    public void showFeelingList(final List<FeelingModel> feelingList) {
        FeelingListAdapter adapter=new FeelingListAdapter(getContext(),feelingList,this);
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                showFeelingList(feelingList);
            }
        });
        feelingListView.setAdapter(adapter);


    }

    @Override
    public void showFeelingDetail(FeelingModel feeling) {

    }

    @Override
    public void showNoFeelingList() {

    }

    @Override
    public void showNoFeelingDetail() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_feeling_comment_button:
            case R.id.id_feeling_commend_button:
            case R.id.id_feeling_share_button:
        }

    }
}
