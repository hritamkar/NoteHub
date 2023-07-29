package com.example.NoteHub;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainPage extends Fragment {
    public ArrayList<NoteModel> arrayList= new ArrayList<>();
    public RecyclerNoteAdapter adapter;

    public MainPage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_page, container, false);
        FloatingActionButton fab_add = rootView.findViewById(R.id.fab_add);
        RecyclerView recyclerView = rootView.findViewById(R.id.notes_list);
        TextView txt_empty= rootView.findViewById(R.id.empty_txt);

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
        arrayList= ((MyApplication) requireActivity().getApplication()).getData();
        if(arrayList.size()==0)
            txt_empty.setAlpha(1);

        adapter = new RecyclerNoteAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return rootView;
    }

}