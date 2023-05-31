package com.example.image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.image.databinding.ActivityTutorial5Binding;

public class Tutorial_5_Activity extends AppCompatActivity {

    ActivityTutorial5Binding binding; // For using Binding Features
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String First_Way;

//                Drawable drawable=getApplicationContext().getDrawable(R.drawable.image6);
//                binding.imageView.setImageDrawable(drawable); // Let's run

                String Second_Way;
//                Drawable drawable1= ContextCompat.getDrawable(Tutorial_5_Activity.this,R.drawable.image6);
//                binding.imageView.setImageDrawable(drawable1);

                String Thrid_Way;
                Drawable drawable2= ActivityCompat.getDrawable(Tutorial_5_Activity.this,R.drawable.image6);
                binding.imageView.setImageDrawable(drawable2);
                // Thanks For Watching


            }
        });

    }
}