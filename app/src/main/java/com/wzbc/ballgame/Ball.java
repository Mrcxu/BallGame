package com.wzbc.ballgame;


import java.util.Random;

public class Ball{
    Random a = new Random();
    int x =500;
    int y =1320;
    int dx = 10;
    int dy = 10;
    int d = 10;
    int xContainer = 1080/8;
    int yContainer = 1920/15;
    int width = 400;
    int height = 400;
    public boolean pausing = false;
    private boolean moving = true;

    public void move(){
        x += dx;
        y -= dy;
        this.wall();
    }

    //碰四周边界反弹
    public void wall(){
        if(x < 0|| x > 1080 - 50 ){
            dx *= -1;
        }
        if(y > 1400||y<0){
            dy *= -1;
        }

    }

    public boolean isGameOver(){
        if (y > 1400 ){
            return true;
        }
        return false;
    }

}
