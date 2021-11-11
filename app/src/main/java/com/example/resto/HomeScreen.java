package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView tName;
    Button consult;
    Button addMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tName = findViewById(R.id.name);
        consult= findViewById(R.id.consult);
        addMenu= findViewById(R.id.addMenu);
        Integer id = getIntent().getIntExtra("id",0);
        tName.setText("welcome to your Restaurent");



        addMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,AddMenu.class).putExtra("idd",id));
            }
        });
        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeScreen.this,Consult.class).putExtra("idd",id));
            }
        });
    }
}