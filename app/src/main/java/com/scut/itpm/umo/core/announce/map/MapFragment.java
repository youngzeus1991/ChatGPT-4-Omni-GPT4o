package com.scut.itpm.umo.core.announce.map;

import android.content.Intent;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.announce.map.add.AddFeelingActivity;
import com.scut.itpm.umo.core.announce.map.add.AddRequirementActivity;

/**
 * Created by DELL on 2016/12/2.
 */

public class MapFragment extends Fragment implements MapContract.View,View.OnClickListener{
    private static  MapFragment INSTANCE;
    private FloatingActionButton actionAdd;
    private MapContract.Presenter mapPresenter;
    public static MapFragment newInstance() {
        if(INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new MapFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mapView=inflater.inflate(R.layout.fragment_map,null);
        actionAdd= (FloatingActionButton) mapView.findViewById(R.id.id_map_action_add);
        actionAdd.setOnClickListener(this);
        return mapView;
    }

    @Override
    public void setPresenter(Object presenter) {
        mapPresenter= (MapContract.Presenter) presenter;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_map_action_add:
                showAddPopupWindow();
                break;
            case R.id.id_switch_add_requirement:
                showAddRequirementActivity();
                break;
            case R.id.id_switch_add_feeling:
                showAddFeelingActivity();
                break;
        }
    }

    private void showAddFeelingActivity() {
        Intent intent=new Intent(getActivity(), AddFeelingActivity.class);
        startActivity(intent);
    }

    private void showAddRequirementActivity() {
        Intent intent=new Intent(getActivity(), AddRequirementActivity.class);
        startActivity(intent);
    }

    private void showAddPopupWindow() {
        View contentView=LayoutInflater.from(getContext()).inflate(R.layout.layout_popup_map_add_switch,null);
        PopupWindow popupWindow=new PopupWindow(contentView,200,200);
        TextView addRequirement= (TextView) contentView.findViewById(R.id.id_switch_add_requirement);
        TextView addFeeling= (TextView) contentView.findViewById(R.id.id_switch_add_feeling);
        addRequirement.setOnClickListener(this);
        addFeeling.setOnClickListener(this);
        popupWindow.setBackgroundDrawable(new PaintDrawable());
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(actionAdd,0,0, Gravity.TOP);
    }

}
