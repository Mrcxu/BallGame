package com.wzbc.ballgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.wzbc.ballgame.Globals.init;

public class MainActivity extends AppCompatActivity {
    Button lvlup;
    Button lvldown;
    Button help;
    Button pause;
    MyView myView;
    int speed = 8;
    Ball ball;
    Pane pane;
    Block blocks[][];
    Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        init(this);
        lvldown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speed = speed - 2;
                pane.w = pane.w - 10;
                pane.a = pane.a + 2;
            }
        });
        lvlup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speed = speed + 2;
                pane.w = pane.w + 5;
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ball.isGameOver()) {
                    new Thread(t).start();
                }
                ball.x =ball.a.nextInt(430)%(430-40+1)+40;
                ball.y = 200;
            }
        });
    }

    public void findView() {
        myView = (MyView) findViewById(R.id.myView);
        lvldown = (Button) findViewById(R.id.down);
        lvlup = (Button) findViewById(R.id.up);
        help = (Button) findViewById(R.id.help);
        pause = (Button) findViewById(R.id.pause);
    }
}
