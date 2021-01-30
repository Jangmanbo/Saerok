package com.example.Saerok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import static android.app.Activity.RESULT_OK;

public class MyPageFragment extends Fragment {
    private static final int GET_IMAGE_FOR_BACKGROUNDIMAGE = 201;
    private static final int GET_IMAGE_FOR_PROFILEIMAGE = 202;
    private ImageView backgroundImage;
    private ImageView profileImage;
    private ImageButton settingsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_mypage, container, false);
        backgroundImage = view.findViewById(R.id.backgroundImage);
        backgroundImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_IMAGE_FOR_BACKGROUNDIMAGE);
            }
        });

        profileImage = view.findViewById(R.id.profileImage);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_IMAGE_FOR_PROFILEIMAGE);
            }
        });
        settingsButton = view.findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri selectedImageUri;

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            switch(requestCode) {
                case GET_IMAGE_FOR_BACKGROUNDIMAGE:
                    selectedImageUri = data.getData();
                    Glide.with(getActivity().getApplicationContext()).load(selectedImageUri).into(backgroundImage);
                    break;
                case GET_IMAGE_FOR_PROFILEIMAGE:
                    selectedImageUri = data.getData();
                    Glide.with(getActivity().getApplicationContext()).load(selectedImageUri).into(profileImage);
                    break;
            }
        }
    }
}
