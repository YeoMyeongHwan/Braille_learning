package com.example.yeo.practice.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.Braille_data.dot_quiz_sentence;
import com.example.yeo.practice.R;


public class quiz_sentence_service extends Service {
    private static final String TAG = "quiz_sentence_service";




    MediaPlayer ssangopen, ssangclose, gualhoopen, gualhoclose, surprise, finish_dot, rest_dot, plus, minus, multiple,
            divide, equal, sangopen, sangclose, wave, twodot, sweat, billiboard;
    MediaPlayer sentence[];
    int rawid[];
    static boolean finish = false;
    static int menu_page = 1;
    int previous=0;
    boolean progress = false;

    public quiz_sentence_service() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        sentence = new MediaPlayer[] {ssangopen, ssangclose, gualhoopen, gualhoclose, surprise, finish_dot, rest_dot, plus, minus, multiple,
                divide, equal, sangopen, sangclose, wave, twodot, sweat, billiboard};

        rawid = new int[] {R.raw.ssangopen0,R.raw.ssangclose0,R.raw.gualhoopen0,R.raw.gualhoclose0,R.raw.surprise0,R.raw.finish_dot,R.raw.rest_dot0,R.raw.plus0,R.raw.minus0,R.raw.multiple0,R.raw.divide0,
                R.raw.equal0,R.raw.sangopen0,R.raw.sangclose0,R.raw.wave0,R.raw.twodot0,R.raw.sweat0,R.raw.billiboard0};

        for(int i = 0; i< dot_quiz_sentence.sentence_count; i++){

            sentence[i] = MediaPlayer.create(this, rawid[i]);
            sentence[i].setLooping(false);
        }
    }
    public void init(){
        if(sentence[previous].isPlaying()) {
            sentence[previous].reset();
            sentence[previous] = MediaPlayer.create(this, rawid[previous]);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
/*
        if(finish == false) {
            if (progress == false) {
                progress = true;
                previous = quiz_sentence.page;
            } else if (progress == true) {
                init();
                previous = quiz_sentence.page;
            }
            sentence[quiz_sentence.page].start();
        }
        else {
            init();
            finish = false;
        }
        */
        return START_NOT_STICKY;
    }
}