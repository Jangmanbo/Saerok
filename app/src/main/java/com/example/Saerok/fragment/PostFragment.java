package com.example.Saerok.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.Saerok.R;

import static android.app.Activity.RESULT_OK;

public class PostFragment extends Fragment {
    //private static final int GET_IMAGE_FOR_IMAGELAYOUT = 205;

    private androidx.appcompat.widget.Toolbar toolbar;
    private ImageButton galleryButton;
    private Spinner spinner;
    private String[] categories={"티켓북", "넷플릭스", "독서", "아무거나"};
    //LinearLayout imageLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_post, container, false);
        toolbar=view.findViewById(R.id.toolbar);
        galleryButton = view.findViewById(R.id.galleryButton);

        spinner=view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), categories[i] + " 카테고리 선택", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_IMAGE_FOR_IMAGELAYOUT);
            }
        });
        */

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.post:
                        Toast.makeText(getActivity(),"등록 버튼 클릭",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

    }


    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri selectedImageUri;

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            switch(requestCode) {
                case GET_IMAGE_FOR_IMAGELAYOUT:
                    selectedImageUri = data.getData();

                    //imageView가 추가될 layout
                    imageLayout = imageLayout.findViewById(R.id.imageLayout);

                    //layout param 생성

                    LinearLayout.LayoutParams layoutParams =
                            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT *//* layout_width *//*, LinearLayout.LayoutParams.WRAP_CONTENT *//* layout_height *//*, 1f *//* layout_weight *//*);
                    ImageView iv = new ImageView(getActivity());  // 새로 추가할 imageView 생성
                    iv.setImageResource(R.drawable.image);  // imageView에 내용 추가
                    iv.setLayoutParams(layoutParams);  // imageView layout 설정
                    imageLayout.addView(iv); // 기존 linearLayout에 imageView 추가

                    Glide.with(getActivity().getApplicationContext()).load(selectedImageUri).into(backgroundImage);
                    break;
            }
        }
    }*/

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.post_toolbar_items,menu);
    }
}
