package com.scut.itpm.umo.core.announce.map.add;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.scut.itpm.umo.BaseActivity;
import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.Main.NavBar.NavBarView;
import com.scut.itpm.umo.core.announce.sociaty.NavBarCallback;

/**
 * Created by DELL on 2016/12/7.
 */

public class AddRequirementActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_requirement);
        init();
    }

    private void init() {
        NavBarView navBarView= (NavBarView) findViewById(R.id.id_add_requirement_nav_bar);
        navBarView.setAddAction(new NavBarCallback() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
