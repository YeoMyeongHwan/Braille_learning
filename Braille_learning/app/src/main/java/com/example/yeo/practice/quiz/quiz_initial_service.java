package com.example.yeo.practice.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.Braille_data.dot_quiz_initial;
import com.example.yeo.practice.R;


public class quiz_initial_service extends Service {
    private static final String TAG = "quiz_initial_service";
    MediaPlayer giyeok,nieun,digeud,nieul,mieum,bieub,siot,zieut,chieut,kieuk,tieut,pieup,hieut,fortis,fgiyeok, fdigued, fbieub, fsiot, fzieut,initfinish;
    MediaPlayer Initial[];
    int rawid[];
    static boolean finish = false;
    static int menu_page = 1;
    int previous=0;
    boolean progress = false;

    public quiz_initial_service() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        Initial = new MediaPlayer[] {giyeok,nieun,digeud,nieul,mieum,bieub,siot,zieut,chieut,kieuk,tieut,pieup,hieut,fortis,fgiyeok, fdigued, fbieub, fsiot, fzieut};
        rawid = new int[] {R.raw.giyeok0,R.raw.nieun0,R.raw.digued0,R.raw.nieul0,R.raw.mieum0,R.raw.bieub0,R.raw.siot0,R.raw.zieut0,R.raw.chieut0,R.raw.kieuk0,
                R.raw.tieut0,R.raw.pieup0,R.raw.hieut0,R.raw.fortis0,R.raw.fortis_giyuck0,R.raw.fortis_digued0,R.raw.fortis_bieub0,R.raw.fortis_siot0,R.raw.fortis_zieut0};



        for(int i = 0; i< dot_quiz_initial.Initialcount; i++){
            Initial[i] = MediaPlayer.create(this, rawid[i]);
            Initial[i].setLooping(false);
        }
    }
    public void init(){
        if(Initial[previous].isPlaying()) {
            Initial[previous].reset();
            Initial[previous] = MediaPlayer.create(this, rawid[previous]);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        /*if(finish == false) {
            if (progress == false) {
                progress = true;
                previous = quiz_initial.page;
            } else if (progress == true) {
                init();
                previous = quiz_initial.page;
            }
            Initial[quiz_initial.page].start();
        }
        else {
            init();
            finish = false;
        }*/
        return START_NOT_STICKY;
    }
}
