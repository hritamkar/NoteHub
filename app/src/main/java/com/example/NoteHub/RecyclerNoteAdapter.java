package com.example.NoteHub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerNoteAdapter extends RecyclerView.Adapter<RecyclerNoteAdapter.viewHolder> {
    Context context;
    ArrayList<NoteModel> arrayList;
    public RecyclerNoteAdapter(Context context,ArrayList<NoteModel> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.note_lay, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).Notename);
        holder.content.setText(arrayList.get(position).Notecontent);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView name,content;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.notename);
            content=itemView.findViewById(R.id.notecontent);
        }
    }
}
