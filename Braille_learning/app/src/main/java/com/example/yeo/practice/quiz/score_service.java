package com.example.yeo.practice.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.R;


public class score_service extends Service {
    private static final String TAG = "Number";
    MediaPlayer zeroscore, onescore, twoscore, threescore, fourscore, fivescore;
    public static int result = 0 ;
    public score_service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        zeroscore= MediaPlayer.create(this, R.raw.zeroscore);
        onescore= MediaPlayer.create(this, R.raw.onescore);
        twoscore= MediaPlayer.create(this, R.raw.twoscore);
        threescore= MediaPlayer.create(this, R.raw.threescore);
        fourscore= MediaPlayer.create(this, R.raw.fourscore);
        fivescore= MediaPlayer.create(this, R.raw.fivescore);

        zeroscore.setLooping(false);
        onescore.setLooping(false);
        twoscore.setLooping(false);
        threescore.setLooping(false);
        fourscore.setLooping(false);
        fivescore.setLooping(false);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        switch(result){
            case 0:
                if(zeroscore.isPlaying()){
                    zeroscore.reset();
                    zeroscore=MediaPlayer.create(this,R.raw.zeroscore);
                }
                zeroscore.start();
                break;
            case 1:
                if(onescore.isPlaying()){
                    onescore.reset();
                    onescore=MediaPlayer.create(this,R.raw.onescore);
                }
                onescore.start();
                break;
            case 2:
                if(twoscore.isPlaying()){
                    twoscore.reset();
                    twoscore=MediaPlayer.create(this,R.raw.twoscore);
                }
                twoscore.start();
                break;
            case 3:
                if(threescore.isPlaying()){
                    threescore.reset();
                    threescore=MediaPlayer.create(this,R.raw.threescore);
                }
                threescore.start();
                break;
            case 4:
                if(fourscore.isPlaying()){
                    fourscore.reset();
                    fourscore=MediaPlayer.create(this,R.raw.fourscore);
                }
                fourscore.start();
                break;
            case 5:
                if(fivescore.isPlaying()){
                    fivescore.reset();
                    fivescore=MediaPlayer.create(this,R.raw.fivescore);
                }
                fivescore.start();
                break;
        }
        return START_NOT_STICKY;
    }
}
