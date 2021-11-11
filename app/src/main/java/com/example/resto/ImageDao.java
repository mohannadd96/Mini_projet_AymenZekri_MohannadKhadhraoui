package com.example.resto;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.resto.Images;

import java.util.List;

@Dao
public interface ImageDao {
    @Insert
    void insert(Images... image);



    @Query("SELECT * FROM Images WHERE idress LIKE :aza")
    List<Images> getAllImage(Integer aza);

    @Delete
    void supp(Images...image);


}