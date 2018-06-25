package com.wzbc.ballgame;

public class Block {
    int x;
    int y;
    int w;
    int h;
    int r;
    int xContainer;
    boolean visible = true;

    public Block(int x, int y, int width, int height) {
        xContainer = width / 8;
        w = width / 8 - 1;
        h = height / 15;
        r = w / 10;
        this.x = x * (w + 1) + xContainer + 1;
        this.y = y * (h + 1) + xContainer + 1;
    }

    public void crash(Ball ball) {
        if (ball.y + ball.d > this.y && ball.y < this.y + this.h  // 纵向区间
                && (ball.x + ball.d == this.x || ball.x == this.x + this.w)  // 横向区间
                ) {
            ball.dx *= -1;
            this.visible = false;
        }
        if (ball.x + ball.d > this.x && ball.x < this.x + this.w  // 纵向区间
                && (ball.y + ball.d == this.y || ball.y == this.y + this.h) // 横向区间
                ) {
            ball.dy *= -1;
            this.visible = false;
        }
    }
}
