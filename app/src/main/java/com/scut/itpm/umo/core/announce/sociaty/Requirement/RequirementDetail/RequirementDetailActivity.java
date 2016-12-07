package com.scut.itpm.umo.core.announce.sociaty.Requirement.RequirementDetail;

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
import com.scut.itpm.umo.core.announce.sociaty.NavBarCallback;
import com.scut.itpm.umo.core.announce.sociaty.PhotoListAdapter;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/12/6.
 */

public class RequirementDetailActivity extends Activity{
    private NavBarView navBarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement_detail);
        Bundle bundle=getIntent().getBundleExtra("bundleRequirementModel");
        initNavBar();
        initData(bundle.getSerializable("requirementModel"));
    }

    @Override
    public void finish() {
        super.finish();
    }

    private void initNavBar() {
        navBarView= (NavBarView) findViewById(R.id.id_requirement_detail_nav_bar);

        navBarView.setDetailAction(new NavBarCallback() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        navBarView.setCurrentTitle("详情");
    }

    private void initData(Serializable requirement) {
        RequirementModel requirementModel=(RequirementModel)requirement;

        ImageView requirementerPhotoImageView= (ImageView) findViewById(R.id.id_requirement_detail_requirementer_photo);
        TextView requirementerNameTextView= (TextView) findViewById(R.id.id_requirement_detail_requirementer_name);
        TextView requirementLocationTextView=(TextView)findViewById(R.id.id_requirement_detail_location);
        TextView requirementMomentTextView= (TextView) findViewById(R.id.id_requirement_detail_moment);
        TextView requirementContentTextView=(TextView)findViewById(R.id.id_requirement_detail_content);
        TextView requirementBookCountTextView=(TextView )findViewById(R.id.id_requirement_detail_book_count);
        TextView requirementCommentCountTextView=(TextView )findViewById(R.id.id_requirement_detail_comment_count);
        TextView requirementViewCountTextView=(TextView)findViewById(R.id.id_requirement_detail_view_count);
        GridView requirementPhotoList=(GridView)findViewById(R.id.id_requirement_detail_photo_list);

        requirementerPhotoImageView.setImageBitmap(((BitmapDrawable)getResources().
                getDrawable(requirementModel.getRequirementerPhotoID())).getBitmap());
        requirementerNameTextView.setText(requirementModel.getRequirementerName());
        requirementLocationTextView.setText(requirementModel.getRequirementLocation());
        requirementMomentTextView.setText(requirementModel.getRequirementMoment());
        requirementContentTextView.setText(requirementModel.getRequirementContent());
        requirementBookCountTextView.setText(requirementModel.getBookCount()+"");
        requirementCommentCountTextView.setText(requirementModel.getCommentCount()+"");
        requirementViewCountTextView.setText(requirementModel.getViewCount()+"");

        List photoIDList=requirementModel.getRequirementImageList();
        List<Bitmap> bitmapList=new ArrayList<>();
        for(int j=0;j<photoIDList.size();j++){
            bitmapList.add(((BitmapDrawable)getResources().getDrawable((int)photoIDList.get(j))).getBitmap());
        }
        PhotoListAdapter adapter=new PhotoListAdapter(this,bitmapList);
        requirementPhotoList.setNumColumns(3);
        requirementPhotoList.setAdapter(adapter);

    }
}
