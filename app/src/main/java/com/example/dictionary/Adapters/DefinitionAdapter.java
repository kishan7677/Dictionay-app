package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Definition;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definition>definitionList;

    public DefinitionAdapter(Context context, List<Definition> definitionList) {
        this.context = context;
        this.definitionList = definitionList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definition_list_items,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textview_definition.setText("Definition "+ definitionList.get(position).getDefinition());
        holder.textview_example.setText("Example "+ definitionList.get(position).getExample());
        StringBuilder synonyms =new StringBuilder();
        StringBuilder antonyms=new StringBuilder();

        synonyms.append(definitionList.get(position).getSynonyms());
        antonyms.append(definitionList.get(position).getAntonyms());
        holder.textview_synonyms.setText(synonyms);
        holder.textview_antonyms.setText(antonyms);

        holder.textview_synonyms.setSelected(true);
        holder.textview_antonyms.setSelected(true);
    }


    @Override
    public int getItemCount() {
        return definitionList.size();
    }
}
