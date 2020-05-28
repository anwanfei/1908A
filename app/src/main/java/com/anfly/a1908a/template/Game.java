package com.anfly.a1908a.template;

public abstract class Game {
    abstract void initialize();

    abstract void startGame();

    abstract void endGame();

    //执行方式-模板
    public void play() {
        initialize();

        startGame();

        endGame();
    }

}
