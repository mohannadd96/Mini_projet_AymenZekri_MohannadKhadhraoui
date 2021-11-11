package com.example.resto;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.resto.MenuEntity;
import com.example.resto.UserEntity;

import java.util.List;
@Dao
public interface MenuDao {


    @Insert
    void InsertMenu(MenuEntity menuEntity);

    @Query("SELECT * from menus where restoid like :ress ")
    List<MenuEntity> getSelectedMenu(Integer ress);

    @Query("SELECT * FROM menus")
    List<UserEntity> getAllMenu();

}
