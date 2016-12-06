package com.scut.itpm.umo.core.inform;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.scut.itpm.umo.R;

public class InformDetail extends Activity {
    private InformPresenter informPresenter;
    private Bundle bundle;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle=getIntent().getBundleExtra(InformConstName.inform_detail_bundle_name);
        setContentView(R.layout.activity_inform_detail);
    }

    @Override
    public void onResume(){
        super.onResume();
        setInformDetailImageView(bundle.getInt(InformConstName.inform_detail_image));
        setInformDetailUserName( bundle.getString(InformConstName.inform_detail_userName));
        setInformDetailMessage(bundle.getString(InformConstName.inform_detail_message));
        setInformDetailTime(bundle.getString(InformConstName.inform_detail_timeDifference));
    }

    public void setPresenter(Object presenter){
        this.informPresenter= (InformPresenter) presenter;
    }

    //set and get function
    private void getInformDetailImageView(){ this.imageView= (ImageView) findViewById(R.id.UserImageDetail);}
    public void setInformDetailImageView(int imageID){
        getInformDetailImageView();
        imageView.setImageResource(imageID);
    }

    private void getInformDetailUserName(){ this.textView= (TextView)findViewById(R.id.UserNameDetail);}
    public void setInformDetailUserName(String UserName){
        getInformDetailUserName();
        textView.setText(UserName);
    }

    private void getInformDetailMessage(){ this.textView= (TextView)findViewById(R.id.MessageDetail); }
    public void setInformDetailMessage(String message){
        getInformDetailMessage();
        textView.setText(message);
    }

    private void getInformDetailTime(){ this.textView= (TextView)findViewById(R.id.TimeDifferenceDetail); }
    public void setInformDetailTime(String TimeDifference){
        getInformDetailTime();
        textView.setText(TimeDifference );
    }

}
