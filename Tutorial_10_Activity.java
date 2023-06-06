package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.image.databinding.ActivityTutorial10Binding;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Tutorial_10_Activity extends AppCompatActivity {

    ActivityTutorial10Binding binding; // For Using Bindging Features
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial10Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Using File Stream
//        try {
//            FileOutputStream fileOutputStream=openFileOutput("imageOne.jpeg",MODE_PRIVATE); // Create Imageone.jpeg
//            Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.image6); // get drawable image
//            bitmap.compress(Bitmap.CompressFormat.JPEG,80,fileOutputStream); // and write image in fileoutput stream
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            // And read file
//            FileInputStream fileInputStream=openFileInput("imageOne.jpeg");
//            Bitmap bitmap=BitmapFactory.decodeStream(fileInputStream);
//            binding.getImage.setImageBitmap(bitmap);
//            // Let's run
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // Using Byte Stream
        binding.addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    // Thanks For watching
                    Bitmap bitmap=BitmapFactory.decodeStream(openFileInput("imageOne.jpeg"));
                    ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG,80, byteArrayOutputStream);
                    byte[] bytes=byteArrayOutputStream.toByteArray();

                    Bitmap bitmap1=BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    binding.getImage.setImageBitmap(bitmap1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //
            }
        });


    }
}