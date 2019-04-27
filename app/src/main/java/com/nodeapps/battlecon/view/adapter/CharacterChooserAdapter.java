package com.nodeapps.battlecon.view.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nodeapps.battlecon.R;
import com.nodeapps.battlecon.view.holder.CharacterChooserViewHolder;

import viewmodel.CharacterChooserViewModel;

public class CharacterChooserAdapter extends RecyclerView.Adapter {
    private String[] data;
    private CharacterChooserViewModel characterChooserViewModel;

    public CharacterChooserAdapter(String[] data) {
        this.data = data;
    }

    public CharacterChooserAdapter(String[] data, CharacterChooserViewModel characterChooserViewModel) {
        this.data = data;
        this.characterChooserViewModel = characterChooserViewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View characterChooserPortraitView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.image_view_character_chooser_portait, viewGroup, false);
        RecyclerView.ViewHolder characterChooserViewHolder = new CharacterChooserViewHolder(characterChooserPortraitView);
        return characterChooserViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((CharacterChooserViewHolder)viewHolder).setCharacterId(data[position]);
        viewHolder.itemView.setOnClickListener(view -> characterChooserViewModel.setChosenCharacter(data[position]));
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
