package com.cos.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView Iv1,Iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Iv1=findViewById(R.id.Iv_1);
        Iv2=findViewById(R.id.Iv_2);
        Glide
                .with(MainActivity.this)
                .load("https://picsum.photos/200/300")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(Iv1);
        Picasso.get()
                .load("https://picsum.photos/200/300")
                .into(Iv2);

    }
}