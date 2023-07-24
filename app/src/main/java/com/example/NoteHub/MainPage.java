package com.example.NoteHub;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainPage extends Fragment {
    public ArrayList<NoteModel> arrayList;
    public RecyclerNoteAdapter adapter;

    public MainPage() {
        arrayList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_page, container, false);
        FloatingActionButton fab_add = rootView.findViewById(R.id.fab_add);
        RecyclerView recyclerView = rootView.findViewById(R.id.notes_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NotePage.class));
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            NoteModel noteModel = bundle.getParcelable("note_model");
            if (noteModel != null ) {
                arrayList.add(noteModel);
            }
        }

        adapter = new RecyclerNoteAdapter(getContext(), arrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return rootView;
    }

}