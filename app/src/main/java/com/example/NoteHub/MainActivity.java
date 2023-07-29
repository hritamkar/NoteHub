package com.example.NoteHub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null && flag==0) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainPage()).commit();
        }

        Intent intent=getIntent();
        if(intent!=null){
            flag=intent.getIntExtra("flag_value",0);
        }

        if(flag==1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainPage()).commit();
        }
    }
}