package com.cos.list;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private final List<Movie> movies;
    private static final String TAG = "ItemAdapter";
    public ItemAdapter(List<Movie> movies){
        this.movies =movies;
    }

    public void addItem(Movie movie){
        movies.add(movie);
        notifyDataSetChanged();
    }
    public void removeItem(int position){
        movies.remove(position);
        notifyDataSetChanged();
    }
    //전체크기를 확인하기 위해서 필요(
    @Override
    public int getCount() {
        return movies.size();
    }

    //클릭하거나 어떤 이벤트 발생시에 컬랙션 정보를 확인하기 위해 필요
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //객체를 생성해서 그림을 그리는 함수
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1. 부모 컨텍스트 가져오기
        MainActivity mainActivity = (MainActivity)parent.getContext();
        //인플레이터 객체 생성완료
        LayoutInflater inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_item,parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText(movies.get(position).getTitle());
        ImageView IvPost = view.findViewById(R.id.Iv_post);
        IvPost.setImageResource(movies.get(position).getPic());
        
        return view;
    }
}
