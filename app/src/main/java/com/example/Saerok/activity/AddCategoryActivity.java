package com.example.Saerok.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.Saerok.R;
import com.example.Saerok.source.CategoryInfoView;

import java.util.ArrayList;
import java.util.Arrays;

public class AddCategoryActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "AddCategoryActivity";
    private Toolbar toolbar;
    private ImageView titleImageView;
    private CardView colorCardView;
    private LinearLayout addItemLayout;
    private LinearLayout categoryInfoArea;
    private int itemNum = 1;
    private static final int GET_IMAGE_FOR_TITLEIMAGE = 210;
    private ArrayList<CheckBox> CheckBoxes;
    String[] types={"단문형 텍스트", "장문형 텍스트", "체크박스", "별점", "사진"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        titleImageView = findViewById(R.id.titleImageView);
        colorCardView = findViewById(R.id.colorCardView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 제거

        titleImageView = findViewById(R.id.titleImageView);
        titleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_IMAGE_FOR_TITLEIMAGE);
            }
        });

        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.checkBox4);
        CheckBox checkBox5 = (CheckBox)findViewById(R.id.checkBox5);
        CheckBox checkBox6 = (CheckBox)findViewById(R.id.checkBox6);
        CheckBox checkBox7 = (CheckBox)findViewById(R.id.checkBox7);
        CheckBox checkBox8 = (CheckBox)findViewById(R.id.checkBox8);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        checkBox2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        checkBox3.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        checkBox4.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        checkBox5.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        checkBox6.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        checkBox7.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        checkBox8.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        CheckBoxes = new ArrayList<CheckBox>(Arrays.asList(checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8));

        Spinner typeSpinner1 = (Spinner)findViewById(R.id.typeSpinner1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        typeSpinner1.setAdapter(adapter);
        typeSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        addItemLayout = (LinearLayout) findViewById(R.id.addItemLayout);
        addItemLayout.setOnClickListener(click);

        categoryInfoArea = (LinearLayout) findViewById(R.id.categoryInfoArea);
    }


    View.OnClickListener click=new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.addItemLayout:
                    categoryInfoArea.addView(new CategoryInfoView(getApplicationContext()));
                    itemNum++;
                    Toast.makeText(getApplicationContext(), "itemNum : "+String.valueOf(itemNum), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };


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

    public void onCheckedChanged(CompoundButton view, boolean b) {
        if(b) {
            for (int i=0; i<CheckBoxes.size();i++) {
                if(CheckBoxes.get(i)!=view) CheckBoxes.get(i).setChecked(false);
            }
            colorCardView.setCardBackgroundColor(Color.parseColor(view.getText().toString()));
        }
        else colorCardView.setCardBackgroundColor(Color.WHITE);
    }
}
