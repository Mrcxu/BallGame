package com.wzbc.ballgame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static com.wzbc.ballgame.Globals.SCREEN_HEIGHT;
import static com.wzbc.ballgame.Globals.SCREEN_WIDTH;


public class MyView extends View {
    int speed = 10;
    Ball ball;
    Pane pane;
    int m = 8;
    int n = 5;
    Block[][] blocks;
    float initX = 500;
    float startX = 0;
    float nowX = 0;
    Boolean ismove = false;
    Boolean isup;
    Boolean isPause = true;
    Handler handler;
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ball = new Ball();
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            Globals.init(activity);
        }
        pane = new Pane();
        blocks = new Block[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = new Block(i, j, SCREEN_WIDTH, SCREEN_HEIGHT);
            }
        }
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        this.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        ismove = false;
                        isup = false;
                        System.out.println("1:" + startX);
                        System.out.println("before:::::" + initX);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (isup) {
                            break;
                        }
                        nowX = event.getX();
                        if (Math.abs(nowX - startX) > 50) {
                            ismove = true;
                            postInvalidate();
                        }
                        if (nowX - startX + initX > 1080) {
                            nowX = 1080 - initX + startX;
                        } else if (nowX - startX + initX < 200) {
                            nowX = 200 - initX + startX;
                        }
//                        initX = (nowX - startX) + initX;
                        System.out.println("nowX::::" + initX);
                        break;
                    case MotionEvent.ACTION_UP:
                        isup = true;
                        if (!ismove) {
                        } else {
                            initX = (nowX - startX) + initX;
                            if (initX < 200) {
                                initX = 200;
                            } else if (initX > 1080) {
                                initX = 1080;
                            }
                        }

                        System.out.println("LastX:::::::::::" + nowX);
                        System.out.println("111X:::::::::::" + startX);
                        System.out.println("afterX:::::" + initX);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        t.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawRect(0, 0, 1080, 2000, paint);   // 边界
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (blocks[i][j].visible) {
                    canvas.drawRoundRect(blocks[i][j].x - blocks[i][j].w, blocks[i][j].y - blocks[i][j].h, blocks[i][j].x, blocks[i][j].y, blocks[i][j].r, blocks[i][j].r, paint);
                }
            }
        }
        paint.setColor(Color.GREEN);
        for (int i = 0; i < m; i++) {
            for (int j = n - 3; j < n - 1; j++) {
                if (blocks[i][j].visible) {
                    canvas.drawRoundRect(blocks[i][j].x - blocks[i][j].w, blocks[i][j].y - blocks[i][j].h, blocks[i][j].x, blocks[i][j].y, blocks[i][j].r, blocks[i][j].r, paint);
                }
            }
        }
        paint.setColor(Color.YELLOW);
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j < n; j++) {
                if (blocks[i][j].visible) {
                    canvas.drawRoundRect(blocks[i][j].x - blocks[i][j].w, blocks[i][j].y - blocks[i][j].h, blocks[i][j].x, blocks[i][j].y, blocks[i][j].r, blocks[i][j].r, paint);
                }
            }
        }
        paint.setColor(Color.WHITE);
        canvas.drawOval(ball.x - ball.d, ball.y - ball.d, ball.x + ball.d, ball.y + ball.d, paint);  // 小球
        paint.setColor(Color.WHITE);
        canvas.drawRoundRect((nowX - startX) + initX - pane.w, pane.y - pane.h, (nowX - startX) + initX, pane.y, pane.r, pane.r, paint); // 挡板
    }

    public boolean iswin() {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (blocks[i][j].visible == true) sum++;
            }
        }
        if (sum == 0) return true;
        else return false;
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (blocks[i][j].visible == true) count++;
            }
        }
        return 40 - count;
    }

    public boolean isGameOver() {
        if (ball.y > 1550) {
            return true;
        }
        return false;
    }

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (!isPause) {
                    ball.move();
                    postInvalidate();
                } else {
                }
                try {
                    t.sleep(speed);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (blocks[i][j].visible) {
                            blocks[i][j].crash(ball);
                        }
                    }
                }
                pane.peng(ball, MyView.this);
                postInvalidate();
                if (count()>=0){
                    handler.sendEmptyMessageDelayed(0, 50);
                }
                if (iswin()) {
                    handler.sendEmptyMessageDelayed(1, 50);
                    return;
                }
                if (isGameOver()) {
                    handler.sendEmptyMessageDelayed(2, 50);
                    return;
                }
            }
        }


    });


    public void reset() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j].visible = true;
            }
        }
        postInvalidate();
    }
}