package com.scut.itpm.umo.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.Main.MainActivity;

/**
 * Created by youyou on 16-4-16.
 */
public class signinActivity extends Activity {

    ImageButton deleteButtonOfEdit;
    EditText qqEdit;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        deleteButtonOfEdit=(ImageButton)findViewById(R.id.delete_button_edit);
        qqEdit=(EditText)findViewById(R.id.qqNum);

        //点击登录
        Button signin=(Button) findViewById(R.id.btn_signin);
        signin.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(signinActivity.this, MainActivity.class);
                startActivity(intent);
                signinActivity.this.finish();
            }
        });

        //点击现在注册
        Button signup=(Button) findViewById(R.id.btn_signup);
        signup.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent =new Intent();
                intent.setClass(signinActivity.this,signupActivity.class);
                startActivity(intent);
                signinActivity.this.finish();
            }
        });


        qqEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qqEdit.getText().toString().equals("")==false){
                    deleteButtonOfEdit.setVisibility(View.VISIBLE);
                }

            }
        });

    }
}
