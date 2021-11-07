package com.example.resto;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from users where userId like :userId and password like :password")
    UserEntity login(String userId,String password);

    @Query("SELECT * FROM users")
    List<UserEntity> getAll();

}
