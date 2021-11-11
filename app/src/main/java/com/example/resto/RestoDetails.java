package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
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

        Integer iddd = getIntent().getIntExtra("id",0);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestoDetails.this,Reservation.class).putExtra("id",iddd));
            }
        });


    }
}