package com.example.image;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.image.databinding.ActivityTutorial8Binding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Tutorial_8_Activity extends AppCompatActivity {

    ActivityTutorial8Binding binding;// For using binding features

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTutorial8Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityResultLauncher.launch(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE});//  1st And 2nd permission
            }
        });

    }

    // For allow to premission
    ActivityResultLauncher<String[]> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
        @Override
        public void onActivityResult(Map<String, Boolean> result) {


            // it will return boolean values
            boolean READ_EXTERNAL_STORAGE = Objects.requireNonNull(result.get(Manifest.permission.READ_EXTERNAL_STORAGE)); // return ture or false
            boolean WRITE_EXTERNAL_STORAGE = Objects.requireNonNull(result.get(Manifest.permission.WRITE_EXTERNAL_STORAGE)); // return true or false

            if (READ_EXTERNAL_STORAGE && WRITE_EXTERNAL_STORAGE) { // if true
                getImage();
                Toast.makeText(Tutorial_8_Activity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else { // or false
                Toast.makeText(Tutorial_8_Activity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        }
    });

    // it will run when permission granted
    public void getImage(){
        Intent intent=new Intent();
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        getMultipleImages.launch(intent); // for open gallery , and taking multiple images
    }
    ActivityResultLauncher<Intent> getMultipleImages=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            ArrayList<String> arrayList=new ArrayList<>();
            Intent intent=result.getData();
            assert intent != null;
            int totalImage=intent.getClipData().getItemCount();
            for (int i=0; i<totalImage; i++){
                arrayList.add(intent.getClipData().getItemAt(i).getUri().toString());
            }

            GridLayoutManager gridLayoutManager=new GridLayoutManager(Tutorial_8_Activity.this,2);
            binding.imageRecyclerView.setLayoutManager(gridLayoutManager);

            modelClass modelClass=new modelClass(arrayList,Tutorial_8_Activity.this);
            binding.imageRecyclerView.setAdapter(modelClass);

            // Not let's run
            // And Before running the programm , you must decalre permission in manifest
        }
    });
}