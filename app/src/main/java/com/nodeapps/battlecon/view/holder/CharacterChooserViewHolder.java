package com.nodeapps.battlecon.view.holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nodeapps.battlecon.R;

import butterknife.BindView;

public class CharacterChooserViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ivCharacterChooserPortrait) ImageView characterPortait;

    public CharacterChooserViewHolder(@NonNull View itemView) {
        super(itemView);
        characterPortait = (ImageView)itemView;
    }
}
