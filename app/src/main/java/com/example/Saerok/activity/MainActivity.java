package com.example.Saerok.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.Saerok.fragment.ListFragment;
import com.example.Saerok.fragment.MyPageFragment;
import com.example.Saerok.fragment.PostFragment;
import com.example.Saerok.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    private BottomNavigationView mBottomNavigationView;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.searchButton:
                Toast.makeText(getApplicationContext(), "검색 버튼", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_toolbar_items, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomNavigationView);

        //첫 화면 띄우기
        getSupportFragmentManager().beginTransaction().add(R.id.linearLayout,new ListFragment()).commit();

        //case 함수를 통해 클릭 받을 때마다 화면 변경하기
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_list :
                        getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,new ListFragment()).commit();
                        break;
                    case R.id.action_post:
                        getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,new PostFragment()).commit();
                        break;
                    case R.id.action_myPage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,new MyPageFragment()).commit();
                        break;

                }
                return true;
            }
        });

    }


}
