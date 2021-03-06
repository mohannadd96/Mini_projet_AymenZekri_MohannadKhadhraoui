package com.example.resto;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.resto.ReservationEntity;

import java.util.List;

@Dao
public interface ReservationDao {

    @Insert
    void registerReservation(ReservationEntity reservationEntity);

    @Query("SELECT * FROM reservations WHERE restoId LIKE :resii")
    List<ReservationEntity> getAll(Integer resii);
}
