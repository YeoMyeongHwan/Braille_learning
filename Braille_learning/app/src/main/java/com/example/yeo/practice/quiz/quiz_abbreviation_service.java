package com.example.yeo.practice.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.Braille_data.dot_quiz_abbreviation;
import com.example.yeo.practice.R;


public class quiz_abbreviation_service extends Service {
    private static final String TAG = "quiz_abbreviation_service";




    MediaPlayer ga, na, da, ma, ba, sa, ja, ka, ta, pa, ha, uk, un, ul, yun, yul, young, ok, on, yong, woon, wool,
            eun, eul, in, abbreviation_siot, gut;
    MediaPlayer abbreviation[];
    int rawid[];
    static boolean finish = false;
    static int menu_page = 1;
    int previous=0;
    boolean progress = false;

    public quiz_abbreviation_service() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        abbreviation = new MediaPlayer[] {ga, na, da, ma, ba, sa, ja, ka, ta, pa, ha, uk, un, ul, yun, yul, young, ok, on, yong, woon, wool,eun,
                eul,in,abbreviation_siot,gut};
        rawid = new int[] {R.raw.ga0,R.raw.na0,R.raw.da0,R.raw.ma0,R.raw.ba0,R.raw.sa0,R.raw.ja0,R.raw.ka0,R.raw.ta0,R.raw.pa0,R.raw.ha0,
                R.raw.uk0,R.raw.un0,R.raw.ul0,R.raw.yun0,R.raw.yul0,R.raw.young0,R.raw.ok0,R.raw.on0,R.raw.on0,R.raw.yong,R.raw.woon,R.raw.wool,
                R.raw.eun,R.raw.eul,R.raw.in,R.raw.abbreviation_siot,R.raw.gut};



        for(int i = 0; i< dot_quiz_abbreviation.abbreviation_count; i++){

            abbreviation[i] = MediaPlayer.create(this, rawid[i]);
            abbreviation[i].setLooping(false);
        }
    }
    public void init(){
        if(abbreviation[previous].isPlaying()) {
            abbreviation[previous].reset();
            abbreviation[previous] = MediaPlayer.create(this, rawid[previous]);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
/*  if(finish == false) {
            if (progress == false) {
                progress = true;
                previous = quiz_abbreviation.page;
            } else if (progress == true) {
                init();
                previous = quiz_abbreviation.page;
            }
            abbreviation[quiz_abbreviation.page].start();
        }
        else {
            init();
            finish = false;
        }
        */
        return START_NOT_STICKY;
    }
}