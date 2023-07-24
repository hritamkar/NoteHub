package com.example.NoteHub;

import android.os.Parcel;
import android.os.Parcelable;

public class NoteModel implements Parcelable{
    String Notename,Notecontent;

    public NoteModel(String name,String content){
        Notename=name;
        Notecontent=content;
    }

    protected NoteModel(Parcel in) {
        Notename = in.readString();
        Notecontent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Notename);
        dest.writeString(Notecontent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NoteModel> CREATOR = new Creator<NoteModel>() {
        @Override
        public NoteModel createFromParcel(Parcel in) {
            return new NoteModel(in);
        }

        @Override
        public NoteModel[] newArray(int size) {
            return new NoteModel[size];
        }
    };
}
