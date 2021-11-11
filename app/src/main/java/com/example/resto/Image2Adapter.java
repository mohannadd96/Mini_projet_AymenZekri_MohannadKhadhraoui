package com.example.resto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Image2Adapter extends RecyclerView. Adapter<Image2Adapter.MyViewHolder>

{
    List arrayList;
    Context context;

    public Image2Adapter(Context context, List arrayList) {


        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_row_main2, parent,false);
        MyViewHolder myViewHolder =new MyViewHolder(view);

        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Images images = (Images) arrayList.get(position);
        holder.imageView.setImageBitmap(ImageBitmapString.getBitMapFromStr(images.getImages()));
        images.setImages (images.getImages());

    }

    @Override
    public int getItemCount() { return arrayList.size(); }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.reserveimg);



        }

    }
}
