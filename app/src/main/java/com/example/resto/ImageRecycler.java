package com.example.resto;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageRecycler extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_recycler);

        recyclerView = findViewById(R.id.rr);

        Integer id = getIntent().getIntExtra("idd",0);
        List<Images> images = DatabaseProviderImg.getDbConnection(getApplicationContext()).imageDao().getAllImage(id);
        ImageAdapter adapter = new ImageAdapter(getApplicationContext(), images);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ;

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
/*
    public void refrechh(){
        Integer id = getIntent().getIntExtra("idd",0);
        startActivity(new Intent(ImageRecycler.this, ImageRecycler.class));
    }*/
}
