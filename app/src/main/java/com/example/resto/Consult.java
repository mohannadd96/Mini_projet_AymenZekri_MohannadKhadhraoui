package com.example.resto;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;


public class Consult extends AppCompatActivity {

    RecyclerView recyclerView;

    List<ReservationEntity> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    UserDatabase userDatabase;
    ReservationListAdapter resadapter;
    TextView tname;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_reservation);
        recyclerView = findViewById(R.id.recycler_view);
        Integer id = getIntent().getIntExtra("idd",0);
        tname = findViewById(R.id.tt);
        //tname.setText(id.toString());
        userDatabase = userDatabase.getUserDatabase(this);
        dataList = userDatabase.reservationDao().getAll(id);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        resadapter = new ReservationListAdapter(Consult.this,dataList);
        recyclerView.setAdapter(resadapter);
    }
}
