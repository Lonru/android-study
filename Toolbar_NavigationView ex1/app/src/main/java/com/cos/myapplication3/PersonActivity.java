package com.cos.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.cos.myapplication3.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class PersonActivity extends AppCompatActivity {
    private Toolbar toolbarMain;
    private ImageView ivBack;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        toolbarMain =findViewById(R.id.toolbar_person);
        setSupportActionBar(toolbarMain);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(v -> {
            finish();
        });

        nv = findViewById(R.id.nav);
        NavigationViewHelper.enable(PersonActivity.this,nv);
    }
}