package com.wzbc.ballgame;


import java.util.Random;

public class Ball {
    Random a = new Random();
    int x = 500;
    int y = 1200;
    int dx = 10;
    int dy = 10;
    int d =30;
    Ball ball;

    public void move() {
        x += dx;
        y -= dy;
        this.wall();
    }

    //碰四周边界反弹
    public void wall() {
        ball = new Ball();
        if (x < ball.d || x > 1080 - ball.d) {
            dx *= -1;
        }
        if (y > 1550 || y < 0) {
            dy *= -1;
        }
    }

}
