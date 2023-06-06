package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.image.databinding.ActivityTutorial9Binding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Tutorial_9_Activity extends AppCompatActivity {

    ActivityTutorial9Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial9Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1st Way
//                binding.imageOne.buildDrawingCache();
//                Bitmap bitmap=binding.imageOne.getDrawingCache();
//                Toast.makeText(Tutorial_9_Activity.this, "Image has Been taken", Toast.LENGTH_SHORT).show();
//                binding.imageTwo.setImageBitmap(bitmap);

                // 2nd Way
                Drawable drawable=binding.imageOne.getDrawable();
                binding.imageTwo.setImageDrawable(drawable);


            }
        });
    }
}