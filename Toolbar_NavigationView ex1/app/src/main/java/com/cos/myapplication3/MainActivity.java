package com.cos.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cos.myapplication3.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private DrawerLayout drawer;
    private NavigationView nv;
    private Toolbar toolbarMain;
    private ImageView ivMenu,ivPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain =findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);
        ivPerson = findViewById(R.id.iv_person);
        ivPerson.setOnClickListener(v -> {
            Intent intent = new Intent(this,PersonActivity.class);
            startActivity(intent);
        });
        ivMenu = findViewById(R.id.iv_menu);
        drawer = findViewById(R.id.drawer);

        ivMenu.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });
        nv = findViewById(R.id.nav);
        NavigationViewHelper.enable(MainActivity.this,nv);


    }
}