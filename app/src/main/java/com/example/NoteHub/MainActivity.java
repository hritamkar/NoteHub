package com.example.NoteHub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainPage()).commit();
        }

        Intent intent = getIntent();
        NoteModel noteModel = null;
        if (intent != null) {
            noteModel = intent.getParcelableExtra("note_model");
        }

        MainPage mainPageFragment = new MainPage();
        Bundle bundle = new Bundle();
        bundle.putParcelable("note_model", noteModel);
        mainPageFragment.setArguments(bundle);

        replaceFragment(mainPageFragment);
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

}