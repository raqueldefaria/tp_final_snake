package com.formationjuniorisep.snake;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public static void main(String[] args) {
        try{
            AppGameContainer appGameContainer = new AppGameContainer(new Game("Le Snake"));
            appGameContainer.setDisplayMode(Game.WIDTH,Game.HEIGHT,false);
            appGameContainer.start();
        } catch(SlickException e){
            e.printStackTrace();
        }
    }
}
