package com.example.dictionary.Models;

import androidx.annotation.NonNull;

public class Phonetics {
    String text = "";
    String audio ="";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
