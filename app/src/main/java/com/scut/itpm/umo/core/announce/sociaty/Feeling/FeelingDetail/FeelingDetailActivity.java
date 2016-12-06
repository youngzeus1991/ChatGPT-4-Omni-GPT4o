package com.scut.itpm.umo.core.announce.sociaty.Feeling.FeelingDetail;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.Main.NavBar.NavBarView;
import com.scut.itpm.umo.core.announce.sociaty.DetailNavBarCallback;
import com.scut.itpm.umo.core.announce.sociaty.PhotoListAdapter;
import com.scut.itpm.umo.data.announce.FeelingModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/12/6.
 */

public class FeelingDetailActivity extends Activity{
    private NavBarView navBarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_detail);
        Bundle bundle=getIntent().getBundleExtra("bundleFeelingModel");
        initNavBar();
        initData(bundle.getSerializable("feelingModel"));
    }

    @Override
    public void finish() {
        super.finish();
    }

    private void initNavBar() {
        navBarView= (NavBarView) findViewById(R.id.id_feeling_detail_nav_bar);

        navBarView.setDetailAction(new DetailNavBarCallback() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        navBarView.setCurrentTitle("详情");
    }

    private void initData(Serializable feeling) {
        FeelingModel feelingModel=(FeelingModel)feeling;

        ImageView feelingerPhotoImageView= (ImageView) findViewById(R.id.id_feeling_detail_feelinger_photo);
        TextView feelingerNameTextView= (TextView) findViewById(R.id.id_feeling_detail_feelinger_name);
        TextView feelingLocationTextView=(TextView)findViewById(R.id.id_feeling_detail_location);
        TextView feelingMomentTextView= (TextView) findViewById(R.id.id_feeling_detail_moment);
        TextView feelingContentTextView=(TextView)findViewById(R.id.id_feeling_detail_content);
        TextView feelingCommentCountTextView=(TextView )findViewById(R.id.id_feeling_detail_comment_count);
        TextView feelingCommendCountTextView=(TextView )findViewById(R.id.id_feeling_detail_commend_count);
        TextView feelingViewCountTextView=(TextView)findViewById(R.id.id_feeling_detail_view_count);
        GridView feelingPhotoList=(GridView)findViewById(R.id.id_feeling_detail_photo_list);

        feelingerPhotoImageView.setImageBitmap(((BitmapDrawable)getResources().
                getDrawable(feelingModel.getFeelingerPhoto())).getBitmap());
        feelingerNameTextView.setText(feelingModel.getFeelingerName());
        feelingLocationTextView.setText(feelingModel.getFeelingLocation());
        feelingMomentTextView.setText(feelingModel.getFeelingMoment());
        feelingContentTextView.setText(feelingModel.getFeelingContent());
        feelingCommentCountTextView.setText(feelingModel.getCommentCount()+"");
        feelingCommendCountTextView.setText(feelingModel.getCommendCount()+"");
        feelingViewCountTextView.setText(feelingModel.getViewCount()+"");

        List photoIDList=feelingModel.getFeelingImageList();
        List<Bitmap> bitmapList=new ArrayList<>();
        for(int j=0;j<photoIDList.size();j++){
            bitmapList.add(((BitmapDrawable)getResources().getDrawable((int)photoIDList.get(j))).getBitmap());
        }
        PhotoListAdapter adapter=new PhotoListAdapter(this,bitmapList);
        feelingPhotoList.setNumColumns(3);
        feelingPhotoList.setAdapter(adapter);

    }
}
