package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {

    EditText rdate, rname,rnum;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        rdate = findViewById(R.id.rdate);
        rname = findViewById(R.id.rname);
        rnum = findViewById(R.id.rnum);
        submit = findViewById(R.id.submit);

        Integer idd = getIntent().getIntExtra("id",0);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReservationEntity reservationEntity = new ReservationEntity();
                reservationEntity.setRestoId(idd);
                reservationEntity.setDate(rdate.getText().toString());
                reservationEntity.setUsername(rname.getText().toString());
                reservationEntity.setPlaces(rnum.getText().toString());
                if (validateInput(reservationEntity)){
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    ReservationDao reservationDao = userDatabase.reservationDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            reservationDao.registerReservation(reservationEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"Rservation Registred",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                } else {
                    Toast.makeText(getApplicationContext(),"Fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private Boolean validateInput(ReservationEntity reservationEntity){
        if( reservationEntity.getRestoId().toString().isEmpty() ||
                reservationEntity.getUsername().isEmpty() ||
                reservationEntity.getDate().isEmpty() ||
                reservationEntity.getPlaces().isEmpty()){
            return false;
        }
        return true;
    }
}