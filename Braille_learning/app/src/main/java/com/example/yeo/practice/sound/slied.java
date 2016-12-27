package com.example.yeo.practice.sound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.R;


public class slied extends Service {
    private static final String TAG = "Number";
    MediaPlayer next,previous;
    static public int slied = 0;
    public slied() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        next= MediaPlayer.create(this, R.raw.next);
        previous= MediaPlayer.create(this, R.raw.previous);
        next.setLooping(false);
        previous.setLooping(false);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        if(slied == 1) {
            next.start();
        }
        else if(slied==2) {
            previous.start();
        }
        return super.onStartCommand(intent, flags, startID);
    }
}
