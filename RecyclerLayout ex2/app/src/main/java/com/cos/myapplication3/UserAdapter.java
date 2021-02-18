package com.cos.myapplication3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private static final String TAG = "UserAdapter";
    private final List<User> users;


    public UserAdapter(List<User> users) {
        this.users = users;
    }

    public void addItem(User user){
        users.add(user);
        notifyDataSetChanged();
    }
    public void removeItem(int position){
        users.remove(position);
    }

    //getView랑 똑같음.
    //차이점이 있다면 listVew는 화면에 3개가 필요하면 최초 로딩시에 3개를 그려야하니까 getView가 3번 호출됨.
    //그다음에 스크롤을 해서 2개가 추가되어야 될 때, 다시 getView를 호출함
    //하지만 recyclerView는 스크롤해서 2개가 추가되어야 할 때 onBindViewHolder를 호출함.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.user_item,parent,false);
        view.setOnClickListener(v -> {
            Log.d(TAG, "onCreateViewHolder:  클릭됨");
        });
        return new MyViewHolder(view); //뷰가 리스트뷰에 하나 그려진다.
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.setItem(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvId;
        private TextView tvUsername;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tv_id);
            tvUsername=itemView.findViewById(R.id.tv_username);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolder: 클릭됨"+getAdapterPosition());
                removeItem(getAdapterPosition());
            });
        }
        private void setItem(User user){
            tvId.setText(user.getId().toString());
            tvUsername.setText(user.getUsername());
        }
    }
}
