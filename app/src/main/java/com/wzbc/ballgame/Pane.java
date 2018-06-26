package com.wzbc.ballgame;

public class Pane {
    int y = 1550;
    int w = 200;
    int h = 50;
    int r = 5;
    int a = 5;
    int error = 10;


    public void peng(Ball ball, MyView view) {
        if (ball.x >= (view.nowX - view.startX + view.initX - this.w) && ball.x < (view.nowX - view.startX + view.initX)
                && ((ball.y + ball.d > this.y - this.h - error) && ball.y + ball.d < this.y - this.h + error)) {
            ball.dy *= -1;
        }
        if (ball.y <= this.y && ball.y >= this.y - this.h
                && ((ball.y - ball.d > (view.nowX - view.startX + view.initX - error) && ball.y - ball.d < (view.nowX - view.startX + view.initX + error))
                || (ball.x + ball.d > (view.nowX - view.startX + view.initX - this.w - error) && ball.x + ball.d < (view.nowX - view.startX + view.initX - this.w + error)))) {
            ball.dx *= -1;
            ball.dy *= -1;
        }
    }
}