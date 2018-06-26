package com.wzbc.ballgame;

public class Block {
    int x;
    int y;
    int w;
    int h;
    int r;
    int xContainer;
    int error = 25;
    boolean visible = true;

    public Block(int x, int y, int width, int height) {
        xContainer = width / 8;
        w = width / 8 - 1;
        h = height / 15;
        r = w / 10;
        this.x = x * (w + 1) + xContainer;
        this.y = y * (h + 1) + xContainer;
    }

    public void crash(Ball ball) {

        if (ball.y <= this.y && ball.y >= this.y - this.h  // 纵向区间
                && ((ball.x - ball.d < this.x + error && ball.x - ball.d > this.x - error)
                || (ball.x + ball.d > this.x - this.w - error && ball.x + ball.d < this.x - this.w + error))  // 横向区间
                ) {
            System.out.println("撞左右：" + (ball.x - ball.d - this.x));
            ball.dx *= -1;
            this.visible = false;
        }
        if (ball.x <= this.x && ball.x
                >= this.x - this.w  // 纵向区间
                && ((ball.y - ball.d < this.y + error && ball.y - ball.d > this.y - error)
                || (ball.y + ball.d > this.y - this.h - error && ball.y + ball.d < this.y - this.h + error)) // 横向区间
                ) {
            System.out.println("撞上下：" + (ball.y - ball.d - this.y));
            ball.dy *= -1;
            this.visible = false;
        }
    }
}
