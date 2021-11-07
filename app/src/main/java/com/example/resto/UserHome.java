package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class UserHome extends AppCompatActivity {

    //EditText editText;
    Button btdetails;
    RecyclerView recyclerView;

    List<UserEntity> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    UserDatabase userDatabase;
    MainAdapter mainadapter;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

       // editText = findViewById(R.id.edi)
        btdetails = findViewById(R.id.bt_reserve);
        recyclerView = findViewById(R.id.recycler_view);
        userDatabase = userDatabase.getUserDatabase(this);
        dataList = userDatabase.userDao().getAll();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mainadapter = new MainAdapter(UserHome.this,dataList);
        recyclerView.setAdapter(mainadapter);


    }
}