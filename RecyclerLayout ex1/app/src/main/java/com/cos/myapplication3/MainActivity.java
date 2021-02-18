package com.cos.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUserList;
    private UserAdapter userAdapter;
    private FontTextView ftv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ftv = findViewById(R.id.ftv);
        ftv.setOnClickListener(v -> {
            ftv.setTextColor(0xFFFF4444);
        });
        List<User> users = new ArrayList<>();
        for(int i=0;i<50;i++) {
            users.add(new User(i, "ssar"));
        }
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        rvUserList=findViewById(R.id.rv_user_list);
        rvUserList.setLayoutManager(manager);
      userAdapter = new UserAdapter(users);

        rvUserList.setAdapter(userAdapter);
    }
}