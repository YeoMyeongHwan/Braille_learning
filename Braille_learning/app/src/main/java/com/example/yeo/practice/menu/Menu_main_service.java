package com.example.yeo.practice.menu;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.R;


public class Menu_main_service extends Service {
    private static final String TAG = "Menu_service";
    MediaPlayer basic,master,quiz, tutorial, explain_tutorial, explain_basic, explain_master, explain_quiz;
    public static int menu_page = 1;
    static boolean finish = false;
    public Menu_main_service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        tutorial = MediaPlayer.create(this, R.raw.directions);
        basic = MediaPlayer.create(this, R.raw.basic);
        master = MediaPlayer.create(this, R.raw.master);
        quiz =MediaPlayer.create(this, R.raw.quiz);

        basic.setLooping(false);
        master.setLooping(false);
        quiz.setLooping(false);
        tutorial.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        switch(menu_page){
            case 1:
                if(quiz.isPlaying()){
                    quiz.reset();
                    quiz=MediaPlayer.create(this,R.raw.quiz);
                }
                if(basic.isPlaying()){
                    basic.reset();
                    basic=MediaPlayer.create(this,R.raw.basic);
                }
                tutorial.start();
                break;
            case 2:
                if(tutorial.isPlaying()){
                    tutorial.reset();
                    tutorial=MediaPlayer.create(this,R.raw.directions);
                }
                if(master.isPlaying()){
                    master.reset();
                    master=MediaPlayer.create(this,R.raw.master);
                }
                basic.start();
                break;
            case 3:
                if(basic.isPlaying()){
                    basic.reset();
                    basic=MediaPlayer.create(this,R.raw.basic);
                }
                if(quiz.isPlaying()){
                    quiz.reset();
                    quiz=MediaPlayer.create(this,R.raw.quiz);
                }
                master.start();
                break;
            case 4:
                if(master.isPlaying()){
                    master.reset();
                    master=MediaPlayer.create(this,R.raw.master);
                }
                if(tutorial.isPlaying()){
                    tutorial.reset();
                    tutorial=MediaPlayer.create(this,R.raw.directions);
                }
                quiz.start();
                break;
        }
        return START_NOT_STICKY;

    }
}
