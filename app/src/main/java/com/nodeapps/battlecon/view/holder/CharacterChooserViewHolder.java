package com.nodeapps.battlecon.view.holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nodeapps.battlecon.R;
import com.nodeapps.battlecon.database.model.CharacterModel;

import butterknife.BindView;

public class CharacterChooserViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ivCharacterChooserPortrait) ImageView characterPortait;
    private CharacterModel characterModel;

    public CharacterChooserViewHolder(@NonNull View itemView) {
        super(itemView);
        characterPortait = (ImageView)itemView;
    }

    public void setCharacterModel(CharacterModel characterModel) {
        this.characterModel = characterModel;
    }
}
