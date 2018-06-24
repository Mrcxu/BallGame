package com.wzbc.ballgame;


import java.util.Random;

public class Ball{
    Random a = new Random();
    int x =a.nextInt(430)%(430-40+1)+40;
    int y =200;
    int dx = 1;
    int dy = 1;
    int d = 10;
    int xContainer = 1080/8;
    int yContainer = 1920/15;
    int width = 400;
    int height = 400;
    private boolean pausing = false;
    private boolean moving = true;

    public void move(){
        x += dx;
        y += dy;
        this.wall();
    }

    //碰四周边界反弹
    public void wall(){
        if(x < this.xContainer || x > this.xContainer+this.width - d ){
            dx *= -1;
        }
        if(y < this.yContainer){
            dy *= -1;
        }

    }

    public boolean isGameOver(){
        if (y > this.yContainer+this.height - d ){
            return true;
        }
        return false;
    }

}
