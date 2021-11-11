package com.example.resto;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;

public class ImageBitmapString {


    @TypeConverter

    public static byte []getStringFromBitmap(Bitmap bitmapPicture) {
        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.PNG, 0, byteArrayBitmapStream);
        byte[] b = byteArrayBitmapStream.toByteArray();
        return b;
    }

        @TypeConverter
        public static Bitmap getBitMapFromStr (byte[] arrr){
            return BitmapFactory.decodeByteArray(arrr,0,arrr.length);
        }
    }
