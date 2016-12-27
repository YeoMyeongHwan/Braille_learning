package com.example.yeo.practice.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.Braille_data.dot_quiz_vowel;
import com.example.yeo.practice.R;


public class quiz_vowel_service extends Service {
    private static final String TAG = "quiz_vowel_service";




    MediaPlayer a,ae,ja,eo,e,yeo,je,o,wa,oi,jo,u,ueo,ju,ei,i,ij,jae,wae,we,wi,vowelfinish;
    MediaPlayer vowel[];
    int rawid[];
    static boolean finish = false;
    static int menu_page = 1;
    int previous=0;
    boolean progress = false;

    public quiz_vowel_service() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        vowel = new MediaPlayer[] {a,ae,ja,eo,e,yeo,je,o,wa,oi,jo,u,ueo,ju,ei,i,ij,jae,wae,we,wi};
        rawid = new int[] {R.raw.vowel_a0,R.raw.vowel_ae,R.raw.vowel_ja0,R.raw.vowel_eo0,R.raw.vowel_e0,R.raw.vowel_yeo0,R.raw.vowel_je0,R.raw.vowel_o0,R.raw.vowel_wa0,R.raw.vowel_oi0,R.raw.vowel_jo0,
                R.raw.vowel_u0,R.raw.vowel_ueo0,R.raw.vowel_ju0,R.raw.vowel_ei0,R.raw.vowel_ij0,R.raw.vowel_i0,R.raw.vowel_jae0,R.raw.vowel_wae0,R.raw.vowel_we0,R.raw.vowel_wi0};



        for(int i = 0; i< dot_quiz_vowel.vowelcount; i++){

            vowel[i] = MediaPlayer.create(this, rawid[i]);
            vowel[i].setLooping(false);
        }
    }
    public void init(){
        if(vowel[previous].isPlaying()) {
            vowel[previous].reset();
            vowel[previous] = MediaPlayer.create(this, rawid[previous]);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        /*
        if(finish == false) {
            if (progress == false) {
                progress = true;
                previous = quiz_vowel.page;
            } else if (progress == true) {
                init();
                previous = quiz_vowel.page;
            }
            vowel[quiz_vowel.page].start();
        }
        else {
            init();
            finish = false;
        }*/
        return START_NOT_STICKY;
    }
}
