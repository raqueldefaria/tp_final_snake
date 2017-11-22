package com.formationjuniorisep.snake;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;

public class Game extends BasicGame {

    public static int WIDTH = 1200;
    public static int HEIGHT = 800;

    private int snakeX, snakeY;
    private int speedX;
    private int speedY;

    int lost;
    int score;

    int targetX;
    int targetY;

    int nbreOfSquares;

    ArrayList listPosition = new ArrayList();

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        speedX = 0;
        speedY = 0;

        score = 0;
        lost = 0;

        snakeX = 500;
        snakeY = 500;

        targetX = 100;
        targetY = 100;

        nbreOfSquares = 1;
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

        Input input = gameContainer.getInput();
        //Position position = new Position();
        Random random = new Random();

        // user's input
        if (input.isKeyDown(Input.KEY_UP)){
            speedX = 0;
            speedY = -1;
        }
        else if (input.isKeyPressed(Input.KEY_DOWN)){
            speedX = 0;
            speedY = 1;
        }
        else if (input.isKeyPressed(Input.KEY_RIGHT)){
            speedX = 1;
            speedY = 0;
        }
        else if (input.isKeyPressed(Input.KEY_LEFT)){
            speedX = -1;
            speedY = 0;
        }

        snakeX += speedX;
        snakeY += speedY;

        // if the snake touches the screen the user looses
        if (snakeX <= 0 || snakeY<=0 || snakeX>=1200 || snakeY>= 800 ){
            lost = 1;
        }

        // if the snake touche an apple
        if (((snakeX>= targetX -40) && (snakeX<= targetX +40)) && ((snakeY>= targetY -40) && (snakeY<= targetY +40)) ){
            //position = new Position(snakeX+20, snakeY+20);
            snakeX = targetX;
            snakeY = targetY;
            targetX = random.nextInt((1150 - 50) + 1) + 50;
            targetX = random.nextInt((750 - 50) + 1) + 50;
            //listPosition.add(position);
            score+=1;
            nbreOfSquares = score + 1;
        }






    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        if (lost == 0){
            graphics.drawString("Score: " + score, 1100, 0);

            //snake +
            for (int it = 0; it<nbreOfSquares; it++){
                graphics.fillRect(snakeX + 20 + it*40, snakeY + 10, 40, 40 );
            }


            //target
            graphics.fillRect(targetX + 20, targetY + 20, 40, 40 );
        }

        else {
            graphics.clear();
            graphics.drawString("Game Over !", 500, 500);
        }


    }
}
