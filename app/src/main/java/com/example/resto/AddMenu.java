package com.example.resto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class AddMenu extends AppCompatActivity {

    Button button;
    ImageView imageView;

    Bitmap bitmap = null;


    int SELECT_PICTURE = 200;

    private ArrayList<Object> bitmaps;
    byte[] imageSources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);
        imageView = findViewById(R.id.image);

    }

    public void upload(View view) { loadImagesFromGallery(); }

    public void save(View view) {
        Images image = new Images();
        Log.d(  "message",  "data="+bitmap);
// Log.d("message", "data="+ImageBitmapString.getStringFromBitmap(bitmap)) ;
        image. setImages (ImageBitmapString.getStringFromBitmap(bitmap)) ;
        DatabaseProviderImg.getDbConnection(getApplicationContext()).imageDao(). insert (image) ;
        Toast.makeText(getApplicationContext(),"Image Saved!", Toast.LENGTH_SHORT).show();


    }

    public void get(View view) {
        startActivity(new Intent(AddMenu.this, ImageRecycler.class));
    }

    private void loadImagesFromGallery() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT) ;
        startActivityForResult(Intent.createChooser(i,"Select Picture"),SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK)
        {

            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                // update the preview image in the Layout
                    // imageView.setImageURI(selectedImageUri.getEncodedPath()) ;
                // Let's read picked image path using content resolver
                    try {
                        bitmap =
                                MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri) ;
                       // imageView.setImageBitmap(bitmap) ;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }}}}}
}



