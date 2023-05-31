package com.example.image;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.image.databinding.ActivityTutorial6Binding;

import java.io.IOException;
import java.util.Objects;

public class Tutorial_6_Activity extends AppCompatActivity {

    // Tutorial 6

    ActivityTutorial6Binding binding; // for using binding Features
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial6Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setTitle("Tutorial 6"); // Set Tool Bar Title

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Method One : - from Drawable
//                MethodOne();

                MethodTwo();
                // Method Two : - From Uri;
                // Let's run

                // Thanks For Watchin


            }
        });
    }
    void  MethodOne(){
        Drawable drawable=getApplicationContext().getDrawable(R.drawable.image6);
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        Bitmap bitmap=bitmapDrawable.getBitmap();

        binding.imageView.setImageBitmap(bitmap);
        // Let's Run
    }
    void  MethodTwo(){
    activityResultLauncher.launch("image/*");
    }
    ActivityResultLauncher<String> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri uri) {
            Bitmap bitmap=null;
            if (uri!=null) {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri); // Convert Uri into Bitmap
                } catch (IOException e) {
                    e.printStackTrace();
                }
                binding.imageView.setImageBitmap(bitmap);
            }

        }
    });

}