package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class RestoDetails extends AppCompatActivity {

    RecyclerView recyclerView2;

    LinearLayoutManager linearLayoutManager;
    Button reserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_details);
        reserve = findViewById(R.id.reservation);
        recyclerView2 = findViewById(R.id.recycler_view2);

        Integer id = getIntent().getIntExtra("id",0);
        List<Images> images = DatabaseProviderImg.getDbConnection(getApplicationContext()).imageDao().getAllImage(id);
        Image2Adapter adapter = new Image2Adapter(getApplicationContext(), images);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        ;

        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(adapter);

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestoDetails.this,Reservation.class).putExtra("id",id));
            }
        });


    }
}