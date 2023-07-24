package com.example.NoteHub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class NotePage extends AppCompatActivity {
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_page);

        AppCompatImageButton btn_done = findViewById(R.id.btn_done);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Create New Note");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EditText noteContent = findViewById(R.id.et_notecontent);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!noteContent.getText().toString().equals("")) {
                    dialog = new Dialog(NotePage.this);
                    dialog.setContentView(R.layout.save_layout);

                    EditText etName = dialog.findViewById(R.id.et_notename);
                    AppCompatButton saveBtn = dialog.findViewById(R.id.btn_save);
                    AppCompatButton cancelBtn = dialog.findViewById(R.id.btn_cancel);
                    String notecontent1 = noteContent.getText().toString();

                    saveBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String notename = "";
                            if (!etName.getText().toString().equals("")) {
                                notename = etName.getText().toString();
                            } else {
                                Toast.makeText(NotePage.this, "Enter Valid name", Toast.LENGTH_SHORT).show();
                            }
                            startActivity(new Intent(NotePage.this, MainActivity.class).putExtra("note_model", new NoteModel(notename, notecontent1)));
                            finish();
                        }
                    });
                    cancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                } else {
                    Toast.makeText(NotePage.this, "Enter note content", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Dismiss the dialog when the activity is paused or destroyed to avoid window leak
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}