package com.example.Saerok.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.Saerok.R;

public class SettingActivity extends AppCompatActivity {
    private static final int GET_IMAGE_FOR_BACKGROUNDIMAGE = 201;
    private static final int GET_IMAGE_FOR_PROFILEIMAGE = 202;
    private ImageView backgroundImage, profileImage;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        backgroundImage = findViewById(R.id.backgroundImage);
        backgroundImage.setOnClickListener(click);

        profileImage = findViewById(R.id.profileImage);
        profileImage.setOnClickListener(click);
    }

    View.OnClickListener click=new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.backgroundImage:
                    intent = new Intent(Intent.ACTION_PICK);
                    intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(intent, GET_IMAGE_FOR_BACKGROUNDIMAGE);
                    break;
                case R.id.profileImage:
                    intent = new Intent(Intent.ACTION_PICK);
                    intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(intent, GET_IMAGE_FOR_PROFILEIMAGE);
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri selectedImageUri;

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            switch(requestCode) {
                case GET_IMAGE_FOR_BACKGROUNDIMAGE:
                    selectedImageUri = data.getData();
                    Glide.with(getApplicationContext()).load(selectedImageUri).into(backgroundImage);
                    break;
                case GET_IMAGE_FOR_PROFILEIMAGE:
                    selectedImageUri = data.getData();
                    Glide.with(getApplicationContext()).load(selectedImageUri).into(profileImage);
                    break;
            }
        }
    }
}
