package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Meaning;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolders.MeaningsViewHolder;

import java.util.List;
import java.util.ListResourceBundle;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {
    private Context context;
    protected List<Meaning>meaningList;

    public MeaningAdapter(Context context, List<Meaning> meaningList) {
        this.context = context;
        this.meaningList = meaningList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items ,  parent,false));

    }


    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.textview_partsOfSpeech.setText("Parts of Speech " +meaningList.get(position).getPartOfSpeech());
        holder.recycler_definition.setHasFixedSize(true);
        holder.recycler_definition.setLayoutManager(new GridLayoutManager(context,1));
        DefinitionAdapter definitionAdapter=new
                DefinitionAdapter(context,meaningList.get(position).getDefinitions());
        holder.recycler_definition.setAdapter(definitionAdapter);


    }


    @Override
    public int getItemCount() {
        return meaningList.size();
    }
}
