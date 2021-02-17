package com.cos.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private GridView lvMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.gv_movie);

        List<Movie> movies = new ArrayList<>();
        for(int i=0;i<20;i++){
            int num = R.drawable.mov01;
            movies.add(new Movie(i,"제목"+i,num));
        }
        ItemAdapter adapter = new ItemAdapter(movies);
        lvMovie.setAdapter(adapter);

    }

}