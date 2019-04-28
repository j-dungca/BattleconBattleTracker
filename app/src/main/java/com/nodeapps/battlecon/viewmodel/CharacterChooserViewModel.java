package com.nodeapps.battlecon.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CharacterChooserViewModel extends ViewModel {
    private MutableLiveData<String> chosenCharacter;

    public CharacterChooserViewModel(){
        chosenCharacter = new MutableLiveData<>();
    }

    public MutableLiveData<String> getChosenCharacter() {
        return chosenCharacter;
    }

    public void setChosenCharacter(String chosenCharacter) {
        if(chosenCharacter != null) {
            this.chosenCharacter.setValue(chosenCharacter);
            return;
        }
    }
}
