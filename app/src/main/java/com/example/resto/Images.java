package com.example.resto;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Images {


        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "image sid")
        private int id;
        public byte[] getImages() { return images; }

        public void setImages(byte[] images) { this. images = images; }

        @ColumnInfo(name = "imageList",typeAffinity = ColumnInfo.BLOB)
        private byte [] images;

        public int getId() { return id; }

        public void setId(int id) { this.id = id; }
}
