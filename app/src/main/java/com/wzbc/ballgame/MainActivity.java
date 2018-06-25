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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        lvlup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myView.speed > 2) {
                    System.out.println("DOWNspeed!!!!!!!!!!!" + myView.speed);
                    myView.speed = myView.speed - 4;
                    myView.pane.w = myView.pane.w - 10;
                    myView.pane.a = myView.pane.a + 2;
                }
            }
        });
        lvldown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myView.speed < 22) {
                    System.out.println("UPspeed!!!!!!!!!!!" + myView.speed);
                    myView.speed = myView.speed + 4;
                    myView.pane.w = myView.pane.w + 5;
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!myView.isPause) {
                    System.out.println("this !" + myView.isPause);
                    myView.isPause = true;
                    pause.setBackgroundResource(R.drawable.play);
                } else {
                    System.out.println("that!:" + myView.isPause);
                    myView.isPause = false;
                    pause.setBackgroundResource(R.drawable.pause);
                }
            }
        });

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("GOOOOOOO!;" + myView.isGameOver());
             if (myView.isGameOver()) {
                 myView.isPause = false;
                 new Thread(myView.t).start();
             }
                myView.isPause = false;
                pause.setBackgroundResource(R.drawable.pause);
                myView.ball.x = myView.ball.a.nextInt(430) % (430 - 40 + 1) + 40;
                myView.ball.y = 1200;

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
