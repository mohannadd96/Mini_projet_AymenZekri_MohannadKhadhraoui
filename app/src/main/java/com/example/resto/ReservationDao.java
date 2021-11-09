package com.example.resto;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReservationDao {

    @Insert
    void registerReservation(ReservationEntity reservationEntity);

    @Query("SELECT * FROM reservations")
    List<ReservationEntity> getAll();
}
