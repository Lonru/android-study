package com.cos.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Context mContext = MainActivity.this;
    private ListView lvMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.lv_movie);
        Log.d(TAG, "컨택스트 ");

        List<Movie> movies = new ArrayList<>();
        for(int i=0;i<20;i++){
            movies.add(new Movie(i,"제목"+1,"서브제목"+i));
        }
        ItemAdapter adapter = new ItemAdapter(movies);
        lvMovie.setAdapter(adapter);

    }

}