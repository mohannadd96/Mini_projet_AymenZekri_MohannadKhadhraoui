package com.example.resto;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menus")
public class MenuEntity {
    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "restoid")
    Integer resId;

    @ColumnInfo(name = "image")
    String image;
    

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
