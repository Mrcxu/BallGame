package com.wzbc.ballgame;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button lvlup;
    Button lvldown;
    Button help;
    Button pause;
    Button newgame;
    MyView myView;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        lvldown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.speed = myView.speed - 2;
                myView.pane.w = myView.pane.w - 10;
                myView.pane.a = myView.pane.a + 2;
            }
        });
        lvlup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.speed = myView.speed + 2;
                myView.pane.w = myView.pane.w + 5;
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!myView.isPause) {
                    pause.setBackgroundResource(R.drawable.pause);
                    new Thread(myView.t).suspend();
                } else {
                    pause.setBackgroundResource(R.drawable.play);
                    new Thread(myView.t).resume();
                }
            }
        });
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myView.ball.isGameOver()) {
                    new Thread(myView.t).start();
                }
                myView.ball.x = myView.ball.a.nextInt(430) % (430 - 40 + 1) + 40;
                myView.ball.y = 200;
                myView.reset();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void findView() {
        myView = (MyView) findViewById(R.id.myView);
        lvldown = (Button) findViewById(R.id.down);
        lvlup = (Button) findViewById(R.id.up);
        help = (Button) findViewById(R.id.help);
        pause = (Button) findViewById(R.id.pause);
        newgame = (Button) findViewById(R.id.newgame);
    }
}
