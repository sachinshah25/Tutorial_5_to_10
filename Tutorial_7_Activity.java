package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.image.databinding.ActivityTutorial7Binding;
import com.squareup.picasso.Picasso;

public class Tutorial_7_Activity extends AppCompatActivity {

    // Tutorial 7

    ActivityTutorial7Binding binding; // For using Binding Features
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial7Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Firstly add Picasso Depdendency  and Glide
                // And Fetch  online image from url
//                Picasso.get().load("https://cdn.pixabay.com/photo/2023/05/20/16/48/dog-8006839_1280.jpg").placeholder(R.drawable.placeholder).into(binding.img);

                // let's run with Glide
                Glide.with(Tutorial_7_Activity.this).load("https://goo.gl/gEgYUd").into(binding.img);
                // Thanks For Watching
            }
        });


    }
}