package com.example.NoteHub;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    private ArrayList<NoteModel> arrayList=new ArrayList<>();

    public ArrayList<NoteModel> getData() {
        return arrayList;
    }

    public void setData(NoteModel noteModel) {
        arrayList.add(noteModel);
    }
}

