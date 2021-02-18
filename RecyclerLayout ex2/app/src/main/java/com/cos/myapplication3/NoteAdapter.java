package com.cos.myapplication3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{
    private final List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }
    public void addNote(Note note){
        notes.add(note);
        notifyDataSetChanged();
    }
    public void removeNote(int position){
        notes.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.note_item,parent,false);
        return new MyViewHolder(view); //뷰가 리스트뷰에 하나 그려진다.

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle,tvSubtitle,tvMin;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvSubtitle=itemView.findViewById(R.id.tv_subtitle);
        tvMin=itemView.findViewById(R.id.tv_min);

        }
        private void setItem(Note note){
            tvTitle.setText(note.getTitle().toString());
            tvSubtitle.setText(note.getSubtitle().toString());
            tvMin.setText(note.getMin().toString());
        }
    }
}
