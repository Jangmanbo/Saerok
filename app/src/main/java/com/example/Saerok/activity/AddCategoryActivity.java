package com.example.Saerok.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.Saerok.R;

import java.util.ArrayList;
import java.util.Arrays;

public class AddCategoryActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView titleImageView;
    private Button galleryButton;
    private ImageButton galleryImageButton;
    private static final int GET_IMAGE_FOR_TITLEIMAGE = 210;
    private ArrayList<CheckBox> CheckBoxes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        titleImageView = findViewById(R.id.titleImageView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 제거

        galleryButton = findViewById(R.id.galleryButton);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_IMAGE_FOR_TITLEIMAGE);
            }
        });

        galleryImageButton = findViewById(R.id.galleryImageButton);
        galleryImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_IMAGE_FOR_TITLEIMAGE);
            }
        });

        CheckBox checkBox = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);


        CheckBoxes = new ArrayList<CheckBox>(Arrays.asList(checkBox, checkBox2, checkBox3, checkBox4));



        checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    for (int i = 0; i<CheckBoxes.size(); i++) {
                        if (CheckBoxes.get(i) != view) {
                            CheckBoxes.get(i).setChecked(false);
                        }
                    }
                }
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    for (int i = 0; i<CheckBoxes.size(); i++) {
                        if (CheckBoxes.get(i) != view) {
                            CheckBoxes.get(i).setChecked(false);
                        }
                    }
                }
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    for (int i = 0; i<CheckBoxes.size(); i++) {
                        if (CheckBoxes.get(i) != view) {
                            CheckBoxes.get(i).setChecked(false);
                        }
                    }
                }
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    for (int i = 0; i<CheckBoxes.size(); i++) {
                        if (CheckBoxes.get(i) != view) {
                            CheckBoxes.get(i).setChecked(false);
                        }
                    }
                }
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }

            case R.id.post:
                Toast.makeText(this.getApplicationContext(), "등록 버튼 클릭",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri selectedImageUri;

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            switch(requestCode) {
                case GET_IMAGE_FOR_TITLEIMAGE:
                    selectedImageUri = data.getData();
                    Glide.with(getApplicationContext()).load(selectedImageUri).into(titleImageView);
                    break;
            }
        }
    }

    //추가된 소스, ToolBar에 menu.xml을 인플레이트함

    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_category_toolbar_items, menu);
        return true;
    }
}
