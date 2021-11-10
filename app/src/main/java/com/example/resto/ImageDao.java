package com.example.resto;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDao {
    @Insert
    void insert(Images... image);


    @Query("SELECT * FROM Images")
    List<Images> getAllImage();
}