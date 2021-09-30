package com.example.Saerok.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Saerok.R;
import com.example.Saerok.activity.AddCategoryActivity;
import com.example.Saerok.activity.SettingActivity;
import com.example.Saerok.adapter.CategoryAdapter;
import com.example.Saerok.etc.CategoryItemDecoration;
import com.example.Saerok.source.CategoryItem;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class MyPageFragment extends Fragment {
    private static final int GET_IMAGE_FOR_BACKGROUNDIMAGE = 201;
    private static final int GET_IMAGE_FOR_PROFILEIMAGE = 202;
    private ImageView backgroundImage, profileImage;
    private ImageButton settingsButton, addCategoryButton;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private ArrayList<CategoryItem> categories;

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

        addCategoryButton = view.findViewById(R.id.addCategoryButton);
        addCategoryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), AddCategoryActivity.class);
                startActivity(intent);
            }
        });

        recyclerView=view.findViewById(R.id.catogoryRecyclerView);
        recyclerView.addItemDecoration(new CategoryItemDecoration(getActivity().getApplicationContext()));
        Log.e("MyPageFragment", "recyclerView find");
        adapter=new CategoryAdapter();

        recyclerView.setAdapter(adapter);
        Log.e("MyPageFragment", "setAdapter");

        recyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 3));
        Log.e("MyPageFragment", "setLayoutManager");

        categories=new ArrayList<>();


        //예시
        categories.add(new CategoryItem("하늘", "#AF1FE3", R.drawable.purplesky));
        categories.add(new CategoryItem("하늘", "#8E8E8E", R.drawable.purplesky));
        categories.add(new CategoryItem("하늘", "#03A9F4", R.drawable.purplesky));
        categories.add(new CategoryItem("하늘", "#3F51B5", R.drawable.purplesky));
        categories.add(new CategoryItem("하늘", "#AF1FE3", R.drawable.purplesky));
        categories.add(new CategoryItem("하늘", "#8E8E8E", R.drawable.purplesky));
        categories.add(new CategoryItem("하늘", "#03A9F4", R.drawable.purplesky));
        categories.add(new CategoryItem("하늘", "#3F51B5", R.drawable.purplesky));

        adapter.setCategories(categories);
        Log.e("MyPageFragment", "setCategories");


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
