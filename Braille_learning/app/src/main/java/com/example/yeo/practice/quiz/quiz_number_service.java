package com.example.yeo.practice.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.Braille_data.dot_quiz_number;
import com.example.yeo.practice.R;


public class quiz_number_service extends Service {
    private static final String TAG = "quiz_number_service";




    MediaPlayer num_sign,zero,one,two,three,four,five,six,seven,eight,nine,ten,twofive,fourseven,sixeight,ninenine;
    MediaPlayer number[];
    int rawid[];
    static boolean finish = false;
    static int menu_page = 1;
    int previous=0;
    boolean progress = false;

    public quiz_number_service() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        number = new MediaPlayer[] {num_sign,zero,one,two,three,four,five,six,seven,eight,nine,ten,twofive,fourseven,sixeight,ninenine};
        rawid = new int[] {R.raw.num_sign0,R.raw.zero0,R.raw.one0,R.raw.two0,R.raw.three0,R.raw.four0,R.raw.five0,R.raw.six0,R.raw.seven0,R.raw.eight0,R.raw.nine0,
                R.raw.ten0,R.raw.twofive0,R.raw.fourseven0,R.raw.sixeight0,R.raw.ninenine0};



        for(int i = 0; i< dot_quiz_number.numbercount; i++){

            number[i] = MediaPlayer.create(this, rawid[i]);
            number[i].setLooping(false);
        }
    }
    public void init(){
        if(number[previous].isPlaying()) {
            number[previous].reset();
            number[previous] = MediaPlayer.create(this, rawid[previous]);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
/*
        if(finish == false) {
            if (progress == false) {
                progress = true;
                previous = quiz_number.page;
            } else if (progress == true) {
                init();
                previous = quiz_number.page;
            }
            number[quiz_number.page].start();
        }
        else {
            init();
            finish = false;
        }*/
        return START_NOT_STICKY;
    }
}
