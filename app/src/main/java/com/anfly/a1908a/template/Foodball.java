package com.anfly.a1908a.template;

import android.util.Log;

public class Foodball extends Game {
    @Override
    void startGame() {
        Log.e("TAG", "Foodball startGame()");
    }

    @Override
    void endGame() {
        Log.e("TAG", "Foodball endGame()");
    }

    @Override
    void initialize() {
        Log.e("TAG", "Foodball initialize()");
    }
}
