package com.example.yeo.practice.sound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;

import com.example.yeo.practice.R;
import com.example.yeo.practice.WHclass;

/*
점자 학습 기능을 위해 출력되는 음성 및 효과음을 관리하는 서비스
 */
public class Number extends Service {
    private static final String TAG = "Number";
    MediaPlayer mnumber1,mnumber2,mnumber3,mnumber4,mnumber5,mnumber6; //남성의 음성으로 1~6
    MediaPlayer wnumber1,wnumber2,wnumber3,wnumber4,wnumber5,wnumber6; //여성의 음성으로 1~6

    MediaPlayer alarm,alarm2; //구분선의 효과음과 이탈방지의 경고음

    public Number() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        //남성의 음성으로 1~6
        mnumber1= MediaPlayer.create(this, R.raw.men_1);
        mnumber2= MediaPlayer.create(this, R.raw.men_2);
        mnumber3= MediaPlayer.create(this, R.raw.men_3);
        mnumber4= MediaPlayer.create(this, R.raw.men_4);
        mnumber5= MediaPlayer.create(this, R.raw.men_5);
        mnumber6= MediaPlayer.create(this, R.raw.men_6);

        //여성의 음성으로 1~6
        wnumber1= MediaPlayer.create(this, R.raw.women_1);
        wnumber2= MediaPlayer.create(this, R.raw.women_2);
        wnumber3= MediaPlayer.create(this, R.raw.women_3);
        wnumber4= MediaPlayer.create(this, R.raw.women_4);
        wnumber5= MediaPlayer.create(this, R.raw.women_5);
        wnumber6= MediaPlayer.create(this, R.raw.women_6);

        //구분선의 효과음과 이탈방지의 경고음
        alarm = MediaPlayer.create(this, R.raw.alarm);
        alarm2 = MediaPlayer.create(this, R.raw.alarm2);

        //반복제거
        mnumber1.setLooping(false);
        mnumber2.setLooping(false);
        mnumber3.setLooping(false);
        mnumber4.setLooping(false);
        mnumber5.setLooping(false);
        mnumber6.setLooping(false);

        wnumber1.setLooping(false);
        wnumber2.setLooping(false);
        wnumber3.setLooping(false);
        wnumber4.setLooping(false);
        wnumber5.setLooping(false);
        wnumber6.setLooping(false);

        alarm.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        if(WHclass.target==true) {
            if (WHclass.number == 1) {
                if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                mnumber1.start();
            } else if (WHclass.number == 2) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                mnumber2.start();
            } else if (WHclass.number == 3) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                mnumber3.start();
            } else if (WHclass.number == 4) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                mnumber4.start();
            } else if (WHclass.number == 5) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                mnumber5.start();
            } else if (WHclass.number == 6) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                mnumber6.start();
            }
            else if (WHclass.number == 7) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                alarm.start();
            }
            else if (WHclass.number == 8) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                alarm2.start();
            }
        }
        else if(WHclass.target==false) {
            if (WHclass.number == 1) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                wnumber1.start();
            } else if (WHclass.number == 2) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                wnumber2.start();
            } else if (WHclass.number == 3) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                wnumber3.start();
            } else if (WHclass.number == 4) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                wnumber4.start();
            } else if (WHclass.number == 5) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber6.isPlaying()){
                    wnumber6.reset();
                    wnumber6=MediaPlayer.create(this,R.raw.women_6);
                }
                wnumber5.start();
            } else if (WHclass.number == 6) {
                if(mnumber1.isPlaying()){
                    mnumber1.reset();
                    mnumber1=MediaPlayer.create(this,R.raw.men_1);
                }if(mnumber2.isPlaying()){
                    mnumber2.reset();
                    mnumber2=MediaPlayer.create(this,R.raw.men_2);
                }if(mnumber3.isPlaying()){
                    mnumber3.reset();
                    mnumber3=MediaPlayer.create(this,R.raw.men_3);
                }if(mnumber4.isPlaying()){
                    mnumber4.reset();
                    mnumber4=MediaPlayer.create(this,R.raw.men_4);
                }if(mnumber5.isPlaying()){
                    mnumber5.reset();
                    mnumber5=MediaPlayer.create(this,R.raw.men_5);
                }if(mnumber6.isPlaying()){
                    mnumber6.reset();
                    mnumber6=MediaPlayer.create(this,R.raw.men_6);
                }if(wnumber1.isPlaying()){
                    wnumber1.reset();
                    wnumber1=MediaPlayer.create(this,R.raw.women_1);
                }if(wnumber2.isPlaying()){
                    wnumber2.reset();
                    wnumber2=MediaPlayer.create(this,R.raw.women_2);
                }if(wnumber3.isPlaying()){
                    wnumber3.reset();
                    wnumber3=MediaPlayer.create(this,R.raw.women_3);
                }if(wnumber4.isPlaying()){
                    wnumber4.reset();
                    wnumber4=MediaPlayer.create(this,R.raw.women_4);
                }if(wnumber5.isPlaying()){
                    wnumber5.reset();
                    wnumber5=MediaPlayer.create(this,R.raw.women_5);
                }
                wnumber6.start();
            }
        }
        return super.onStartCommand(intent, flags, startID);
    }
}
