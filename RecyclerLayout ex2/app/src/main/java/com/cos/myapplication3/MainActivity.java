package com.cos.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontTextView;
import lombok.NonNull;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNoteList;
    private NoteAdapter noteAdapter;
    private FontTextView ftv;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ftv = findViewById(R.id.ftv);
        ftv.setOnClickListener(v -> {
            ftv.setTextColor(0xFFFF4444);
        });
        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            notes.add(new Note(i, "titled", "dwwd", i));
        }
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvNoteList = findViewById(R.id.rv_user_list);
        rvNoteList.setLayoutManager(manager);
        noteAdapter = new NoteAdapter(notes);

        rvNoteList.setAdapter(noteAdapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {


            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Log.d(TAG, "onSwiped: 스와이프");
                Log.d(TAG, "onSwiped: 번호 : " + viewHolder.getAdapterPosition());
                noteAdapter.removeNote(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvNoteList);

    }
}