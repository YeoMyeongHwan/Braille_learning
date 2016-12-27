package com.example.yeo.practice.menu;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.R;


public class Menu_service extends Service {
    private static final String TAG = "Menu_service";
    MediaPlayer Init,Final,Vowel,tutorial,number,alphabet, Sentence,abbreviation,basicfinish;
    public static int menu_page = 1;
    static boolean finish = false;
    public Menu_service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Sentence = MediaPlayer.create(this, R.raw.start_sentence);
        Init = MediaPlayer.create(this, R.raw.initial);
        Final =MediaPlayer.create(this, R.raw.finalconsonant);
        Vowel = MediaPlayer.create(this, R.raw.vowel);
        tutorial = MediaPlayer.create(this, R.raw.directions);
        number = MediaPlayer.create(this, R.raw.number);
        alphabet = MediaPlayer.create(this, R.raw.alphabet);
        basicfinish = MediaPlayer.create(this, R.raw.basicfinish);
        abbreviation = MediaPlayer.create(this, R.raw.abbreviation_start);
        Init.setLooping(false);
        Final.setLooping(false);
        Vowel.setLooping(false);
        basicfinish.setLooping(false);
        tutorial.setLooping(false);
        number.setLooping(false);
        alphabet.setLooping(false);
        abbreviation.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        if(finish == false) {
            switch (menu_page) {
                case 1:
                    if (abbreviation.isPlaying()) {
                        abbreviation.reset();
                        abbreviation = MediaPlayer.create(this, R.raw.abbreviation_start);
                    }
                    if (Vowel.isPlaying()) {
                        Vowel.reset();
                        Vowel = MediaPlayer.create(this, R.raw.vowel);
                    }
                    Init.start();
                    break;
                case 2:
                    if (Init.isPlaying()) {
                        Init.reset();
                        Init = MediaPlayer.create(this, R.raw.initial);
                    }
                    if (Final.isPlaying()) {
                        Final.reset();
                        Final = MediaPlayer.create(this, R.raw.finalconsonant);
                    }
                    Vowel.start();
                    break;
                case 3:
                    if (Vowel.isPlaying()) {
                        Vowel.reset();
                        Vowel = MediaPlayer.create(this, R.raw.vowel);
                    }
                    if (number.isPlaying()) {
                        number.reset();
                        number = MediaPlayer.create(this, R.raw.number);
                    }
                    Final.start();
                    break;
                case 4:
                    if (Final.isPlaying()) {
                        Final.reset();
                        Final = MediaPlayer.create(this, R.raw.finalconsonant);
                    }
                    if (alphabet.isPlaying()) {
                        alphabet.reset();
                        alphabet = MediaPlayer.create(this, R.raw.alphabet);
                    }
                    number.start();
                    break;
                case 5:
                    if (number.isPlaying()) {
                        number.reset();
                        number = MediaPlayer.create(this, R.raw.number);
                    }
                    if (Sentence.isPlaying()) {
                        Sentence.reset();
                        Sentence = MediaPlayer.create(this, R.raw.start_sentence);
                    }
                    alphabet.start();
                    break;
                case 6:
                    if (alphabet.isPlaying()) {
                        alphabet.reset();
                        alphabet = MediaPlayer.create(this, R.raw.alphabet);
                    }
                    if (abbreviation.isPlaying()) {
                        abbreviation.reset();
                        abbreviation = MediaPlayer.create(this, R.raw.abbreviation_start);
                    }
                    Sentence.start();
                    break;
                case 7:
                    if (Sentence.isPlaying()) {
                        Sentence.reset();
                        Sentence = MediaPlayer.create(this, R.raw.start_sentence);
                    }
                    if (Init.isPlaying()) {
                        Init.reset();
                        Init = MediaPlayer.create(this, R.raw.initial);
                    }
                    abbreviation.start();
                    break;

            }
        }
        else{
            basicfinish.start();
            finish=false;
            basicfinish.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    basicfinish.reset();
                    basicfinish = MediaPlayer.create(Menu_service.this,R.raw.basicfinish);
                }
            });
        }
        return START_NOT_STICKY;
    }
}
