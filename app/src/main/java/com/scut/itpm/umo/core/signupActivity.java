package com.scut.itpm.umo.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.scut.itpm.umo.R;

/**
 * Created by youyou on 16-4-17.
 */
public class signupActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //点击返回
        Button back=(Button) findViewById(R.id.btn_back);
        back.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(signupActivity.this, signinActivity.class);
                startActivity(intent);
                signupActivity.this.finish();
            }
        });

    }

    // 按下键盘底部返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent();
            intent.setClass(signupActivity.this, signinActivity.class);
            startActivity(intent);
            signupActivity.this.finish();
        }

        return false;
    }
}
