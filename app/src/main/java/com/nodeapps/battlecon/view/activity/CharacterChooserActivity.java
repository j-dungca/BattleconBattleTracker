package com.nodeapps.battlecon.view.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.nodeapps.battlecon.R;
import com.nodeapps.battlecon.database.RosterDataSource;
import com.nodeapps.battlecon.database.RosterDatabase;
import com.nodeapps.battlecon.view.adapter.CharacterChooserAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import com.nodeapps.battlecon.viewmodel.CharacterChooserViewModel;

public class CharacterChooserActivity extends AppCompatActivity {

    private static final String[] DEBUG_CHARACTERS = {"Ace","Bean","Craig","Domino","Eric","Fatima"};

    @BindView(R.id.tvCharacterSelectTitle) TextView characterSelectTitleTextView;
    @BindView(R.id.tvCharacterName) TextView characterNameTextView;
    @BindView(R.id.tvCharacterDescription) TextView characterDescriptionTextView;
    @BindView(R.id.ivCharacterPortrait) ImageView characterPortraitImageView;
    @BindView(R.id.rvCharacterList) RecyclerView characterChooserRecyclerView;
    RecyclerView.LayoutManager characterChooserLayoutManager;
    RecyclerView.Adapter characterChooserAdapter;
    CharacterChooserViewModel characterChooserViewModel;

    RosterDataSource rosterDataSource;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_chooser);
        ButterKnife.bind(this);

        // create Observer
        final Observer<String> nameObserver = newName -> characterNameTextView.setText(newName);

        // set ViewModel
        characterChooserViewModel = ViewModelProviders.of(this).get(CharacterChooserViewModel.class);
        characterChooserViewModel.getChosenCharacter().observe(this, nameObserver);

        // Initialize Database/Room
        RosterDatabase.getInstance(getApplicationContext());
        rosterDataSource = new RosterDataSource(
                RosterDatabase.getInstance(getApplicationContext()).characterDao(),
                RosterDatabase.getInstance(getApplicationContext()).setDao());

        init();
        initRecyclerView(this);

    }

    private void initRecyclerView(Context context) {
        characterChooserRecyclerView.setHasFixedSize(true);
        characterChooserLayoutManager = new GridLayoutManager(this,3);
        mDisposable.add(rosterDataSource.getCharacterModels(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(characterModels -> {
                    characterChooserAdapter = new CharacterChooserAdapter(
                            characterModels, characterChooserViewModel);
                    characterChooserRecyclerView.setLayoutManager(characterChooserLayoutManager);
                    characterChooserRecyclerView.setAdapter(characterChooserAdapter);
                }));
    }

    private void init() {
        characterSelectTitleTextView.setText(getString(R.string.characterchooser_title));
        // TODO: Fix imageView

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
