package com.example.resto;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<UserEntity> userEntity;
    private Activity context;
    private UserDatabase database;

    public MainAdapter(Activity context,List<UserEntity> userEntity){
        this.context =context;
        this.userEntity = userEntity;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserEntity data = userEntity.get(position);
        database = database.getUserDatabase(context);
        holder.textView.setText(data.getName());

    }

    @Override
    public int getItemCount() {
        return userEntity.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView btreserve;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            btreserve = itemView.findViewById(R.id.bt_reserve);
        }
    }


}
