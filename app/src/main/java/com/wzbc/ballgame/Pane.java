package com.wzbc.ballgame;

import static com.wzbc.ballgame.Globals.SCREEN_HEIGHT;
import static com.wzbc.ballgame.Globals.SCREEN_WIDTH;

public class Pane {
    int x = 100;
    int y = 1400;
    int w = 200;
    int h = 30;
    int r = 5;
    int a=5;


    public void peng(Ball ball){
        if(ball.x + ball.d > this.x && ball.x < this.x + this.w && (ball.y + ball.d == this.y || ball.y == this.y + this.h)){
            ball.dy *=-1;
        }
        if(ball.y + ball.d > this.y && ball.y < this.y + this.h && (ball.x + ball.d == this.x || ball.x == this.x + this.w )){
            ball.dx *=-1;
        }
    }
}