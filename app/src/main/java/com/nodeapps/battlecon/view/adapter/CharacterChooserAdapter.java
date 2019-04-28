package com.nodeapps.battlecon.view.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nodeapps.battlecon.R;
import com.nodeapps.battlecon.database.model.CharacterModel;
import com.nodeapps.battlecon.view.holder.CharacterChooserViewHolder;

import com.nodeapps.battlecon.viewmodel.CharacterChooserViewModel;

import java.util.List;

public class CharacterChooserAdapter extends RecyclerView.Adapter {
    private List<CharacterModel> data;
    private CharacterChooserViewModel characterChooserViewModel;

    public CharacterChooserAdapter(List<CharacterModel> data, CharacterChooserViewModel characterChooserViewModel) {
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
        ((CharacterChooserViewHolder)viewHolder).setCharacterModel(data.get(position));
        viewHolder.itemView.setOnClickListener(view -> characterChooserViewModel.setChosenCharacter(data.get(position).characterName));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
