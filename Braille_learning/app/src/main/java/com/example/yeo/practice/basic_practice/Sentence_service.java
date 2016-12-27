package com.example.yeo.practice.basic_practice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.Braille_data.dot_sentence;
import com.example.yeo.practice.Display_Practice.Braille_short_display;
import com.example.yeo.practice.R;


public class Sentence_service extends Service {
    /*
     문장부호 연습에서 출력되는 음성파일을 관리하는 서비스 클래스
     */
    private static final String TAG = "Sentence_service";
    MediaPlayer ssangopen, ssangclose, gualhoopen, gualhoclose, surprise, finish_dot, rest_dot, plus, minus, multiple, divide, equal, sangopen, sangclose, wave, twodot, sweat, billiboard;
    MediaPlayer sentencefinish;
    MediaPlayer sentence[];// 선언된 음성 변수들을 배열 변수에 저장
    int rawid[];// 음성파일의 id 주소를 배열변수에 저장

    public static boolean finish = false;
    static int menu_page = 1;
    int previous=0;
    boolean progress = false;

    public Sentence_service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){

        sentencefinish = MediaPlayer.create(this, R.raw.setence_finish);
        sentencefinish.setLooping(false);

        sentence = new MediaPlayer[]{ssangopen, ssangclose, gualhoopen, gualhoclose, surprise, finish_dot, rest_dot, plus, minus, multiple,
                divide, equal, sangopen, sangclose, wave, twodot, sweat, billiboard};
        // 선언된 음성 변수들을 배열 변수에 저장

        rawid =new int[]{R.raw.ssangopen,R.raw.ssangclose,R.raw.gualhoopen,R.raw.gualhoclose,R.raw.surprise,R.raw.finish_dot,R.raw.rest_dot,R.raw.plus
                ,R.raw.minus,R.raw.multiple,R.raw.divide,R.raw.equal,R.raw.sangopen,R.raw.sangclose,R.raw.wave,R.raw.twodot,R.raw.sweat,R.raw.billiboard};
        // 음성파일의 id 주소를 배열변수에 저장


        for(int i = 0; i< dot_sentence.sentence_count; i++){
            sentence[i] = MediaPlayer.create(this, rawid[i]);
            sentence[i].setLooping(false);
        }


    }
    public void init(){ //사용한 음성파일을 재 설정해주는 함수
        if(sentence[previous].isPlaying()) {
            sentence[previous].reset();
            sentence[previous] = MediaPlayer.create(this, rawid[previous]);
        }
        if(finish==true){
            for(int i = 0 ; i<dot_sentence.sentence_count; i++){
                sentence[i].reset();
                sentence[i] = MediaPlayer.create(this, rawid[i]);
            }
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        if(finish == false) {
            if(progress == false){
                progress = true;
                previous = Braille_short_display.page;
            }
            else if(progress == true){
                init();
                previous= Braille_short_display.page;
            }
            sentence[Braille_short_display.page].start();

        }
        else {
            init();
            sentencefinish.start();
            finish = false;
            sentencefinish.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    sentencefinish.reset();
                    sentencefinish = MediaPlayer.create(Sentence_service.this, R.raw.setence_finish);
                }
            });
        }
        return START_NOT_STICKY;
    }
}