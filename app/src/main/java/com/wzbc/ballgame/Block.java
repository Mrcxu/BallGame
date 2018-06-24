package com.wzbc.ballgame;

import static com.wzbc.ballgame.Globals.SCREEN_HEIGHT;
import static com.wzbc.ballgame.Globals.SCREEN_WIDTH;

public class Block {
    int x;
    int y;
    int w = 1080/8-1;
    int h = 1920/15;

    int r = w/10;
    int xContainer = 1080/8;
    boolean visible = true;
    public Block(int x, int y){
        this.x = x*(w+1) + xContainer + 1;
        this.y = y*(h+1) + xContainer + 1;
    }

    public void crash(Ball ball){
        if(ball.y + ball.d > this.y && ball.y < this.y + this.h  // 纵向区间
        && (ball.x + ball.d == this.x || ball.x == this.x + this.w )  // 横向区间
        ){
            ball.dx *= -1;
            this.visible = false;
        }
        if(ball.x + ball.d > this.x && ball.x < this.x + this.w  // 纵向区间
        && (ball.y + ball.d == this.y || ball.y == this.y + this.h ) // 横向区间
        ){
            ball.dy *= -1;
            this.visible = false;
        }
    }
}
