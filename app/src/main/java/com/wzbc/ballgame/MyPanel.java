//package com.wzbc.ballgame;
//
//
//public class MyPanel {
//    Thread t = null;
//    int speed = 8;
//    Ball ball;
//    Pane pane;
//    int m = 8;
//    int n = 5;
//    Block[][] blocks;
//    private MyWindow myWindow;
//    public boolean isPause = false;
//
//    public  boolean iswin(){
//        int sum = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(blocks[i][j].visible == true)sum++;
//            }
//        }
//        if(sum==0)return true;
//        else return false;
//    }
//
//    public MyPanel() {
//
////        t.start();
//    }
//
//    public void paint(Graphics g) {
//
//    }
//    public boolean Pause(){
//        this.t.suspend();
//        return true;
//    }
//
//
//
////    public void pauseGame() {
////        if (this.ball != null) {
////            this.ball.setPausing(true);
////        }
////
////    }
////
////    public void resumeGame() {
////        if (this.ball != null) {
////            this.ball.setPausing(false);
////        }
////
////    }
//
//
//    public void keyPressed() {
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            pane.left();
//        }
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            pane.right();
//        }
//        if (VK_UP) {
//
//        }
//        if VK_DOWN) {
//
//        }
//        if (VK_F2){
//
//        }
//        if(VK_SPACE){
//            if(!isPause){
//                isPause = true;
//            }else {
//                isPause = false;
//            }
//        }
//        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//            System.exit(0);
//        }
//    }
//
//    public void keyReleased() {
//        // TODO Auto-generated method stub
//    }
//
//    public void keyTyped() {
//        // TODO Auto-generated method stub
//    }
//}