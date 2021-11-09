package com.example.resto;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "reservations")
public class ReservationEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "places")
    String places;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "restoId")
    Integer restoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRestoId() {
        return restoId;
    }

    public void setRestoId(Integer restoId) {
        this.restoId = restoId;
    }
}
