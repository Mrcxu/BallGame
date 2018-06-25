package com.wzbc.ballgame;


import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.listener.DialogUIListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {
    SystemBarTintManager tintManager;
    Button lvlup;
    Button lvldown;
    Button help;
    Button pause;
    Button newgame;
    MyView myView;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        findView();
        initWindow();
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

                if(myView.isPause==false){
                    i =1;
                    myView.isPause=true;
                }else{
                    i=0;
                }
                DialogUIUtils.showAlert(MainActivity.this, "帮助", "游戏介绍：一款经典的打砖块游戏，画面清晰玩法简单，运行流畅。\n" +
                        "游戏玩法：在游戏中，玩家通过按住并滑动屏幕控制挡板左右移动，接住击打砖块而改变飞行轨迹掉落下来的小球。并使小球与砖块碰撞消除。\n" +
                        "游戏目标：在限定的时间内消除所有的方块并且没有掉落即可过关。\n", new DialogUIListener() {

                    @Override
                    public void onPositive() {
                        if (i==1)
                            myView.isPause=false;
                    }

                    @Override
                    public void onNegative() {
                        if (i==1)
                            myView.isPause=false;
                    }

                }).show();

            }
        });
    }

    private void initWindow() {//初始化窗口属性，让状态栏和导航栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            tintManager = new SystemBarTintManager(this);
            int statusColor = Color.parseColor("#7b7c7c");
            tintManager.setStatusBarTintColor(statusColor);
            tintManager.setStatusBarTintEnabled(true);
        }
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
