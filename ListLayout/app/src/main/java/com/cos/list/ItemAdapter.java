package com.cos.list;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private final List<Movie> movies;
    private static final String TAG = "ItemAdapter";
    public ItemAdapter(List<Movie> movies){
        this.movies =movies;
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

        Log.d(TAG, "getView: "+position);
        if(convertView==null){
            Log.d(TAG, "convertView가 null입니다. ");
        }else{
            Log.d(TAG, "convertView가 null이 아닙니다. ");
        }
        //1. 부모 컨텍스트 가져오기
        Context context = parent.getContext();
        //인플레이터 객체 생성완료
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_item,parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubTitle = view.findViewById(R.id.tv_subtitle);
        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getSubTitle());

        view.setOnClickListener(v -> {
           // Toast.makeText(context, "클릭됨"+position, Toast.LENGTH_SHORT).show();
            //스타트엑티비티가 안먹힌다.
            Intent intent = new Intent(context,DetailActivity.class);
            intent.putExtra("title",movies.get(position).getTitle());
            context.startActivity(intent);
        });
        view.setOnLongClickListener(v -> {
            Toast.makeText(context, "롱클릭됨", Toast.LENGTH_SHORT).show();
            movies.remove(position);
            Log.d(TAG, "movies 변경 사이즈: "+movies.size());
            this.notifyDataSetChanged();
            return true;
        });
        return view;
    }
}
