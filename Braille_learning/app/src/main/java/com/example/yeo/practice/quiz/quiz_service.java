package com.example.yeo.practice.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.yeo.practice.R;


public class quiz_service extends Service {
    private static final String TAG = "Number";
    public static MediaPlayer first, second, third, forth, last, quizmanual,quiz_finish, initial_quiz_finish, vowel_quiz_finish, final_quiz_finish,
            num_quiz_finish, alphabet_quiz_finish, sentence_quiz_finish, abbreviation_quiz_finish, word_quiz_finish, letter_quiz_finish;
    public static int question =0 ;
    public static int finish_n = 0;
    public quiz_service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        quizmanual= MediaPlayer.create(this, R.raw.quiz_manual);
        first= MediaPlayer.create(this, R.raw.first_quiz);
        second= MediaPlayer.create(this, R.raw.second_quiz);
        third= MediaPlayer.create(this, R.raw.third_quiz);
        forth= MediaPlayer.create(this, R.raw.forth_quiz);
        last= MediaPlayer.create(this, R.raw.last_quiz);
        quiz_finish = MediaPlayer.create(this, R.raw.quiz_finish);
        initial_quiz_finish = MediaPlayer.create(this, R.raw.initial_quiz_finish);
        vowel_quiz_finish = MediaPlayer.create(this, R.raw.vowel_quiz_finish );
        final_quiz_finish = MediaPlayer.create(this, R.raw.final_quiz_finish);
        num_quiz_finish  = MediaPlayer.create(this, R.raw.num_quiz_finish );
        alphabet_quiz_finish  = MediaPlayer.create(this, R.raw.alphabet_quiz_finish );
        sentence_quiz_finish  = MediaPlayer.create(this, R.raw.sentence_quiz_finish );
        abbreviation_quiz_finish  = MediaPlayer.create(this, R.raw.abbreviation_quiz_finish );
        word_quiz_finish  = MediaPlayer.create(this, R.raw.word_quiz_finish );
        letter_quiz_finish = MediaPlayer.create(this, R.raw.letter_quiz_finish);

        initial_quiz_finish .setLooping(false);
        vowel_quiz_finish .setLooping(false);
        final_quiz_finish.setLooping(false);
        num_quiz_finish .setLooping(false);
        alphabet_quiz_finish .setLooping(false);
        sentence_quiz_finish .setLooping(false);
        abbreviation_quiz_finish .setLooping(false);
        word_quiz_finish.setLooping(false);
        letter_quiz_finish.setLooping(false);

        quizmanual.setLooping(false);
        first.setLooping(false);
        second.setLooping(false);
        third.setLooping(false);
        forth.setLooping(false);
        last.setLooping(false);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        switch(question){
            case 0:
                quizmanual.start();
                break;
            case 1:
                if(quizmanual.isPlaying()){
                    quizmanual.reset();
                    quizmanual=MediaPlayer.create(this,R.raw.quiz_manual);
                }
                first.start();
                break;
            case 2:
                if(first.isPlaying()){
                    first.reset();
                    first=MediaPlayer.create(this,R.raw.first_quiz);
                }
                second.start();
                break;
            case 3:
                if(second.isPlaying()){
                    second.reset();
                    second=MediaPlayer.create(this,R.raw.second_quiz);
                }
                third.start();
                break;
            case 4:
                if(third.isPlaying()){
                    third.reset();
                    third=MediaPlayer.create(this,R.raw.third_quiz);
                }
                forth.start();
                break;
            case 5:
                if(forth.isPlaying()){
                    forth.reset();
                    forth=MediaPlayer.create(this,R.raw.forth_quiz);
                }
                last.start();
                question = 0;
                break;
            case 6:
                if(quizmanual.isPlaying()){
                    quizmanual.reset();
                    quizmanual=MediaPlayer.create(this,R.raw.quiz_manual);
                    question = 0;
                    if(finish_n == 0){
                        initial_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 1){
                        vowel_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 2){
                        final_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 3){
                        num_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 4){
                        alphabet_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 5){
                        sentence_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 6){
                        abbreviation_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 7){
                        letter_quiz_finish.start();
                        finish_n = 0;
                    }else if(finish_n == 8){
                        word_quiz_finish.start();
                        finish_n = 0;
                    }
                }
                break;
            case 7:
                quiz_finish.start();
                question = 0;
                break;
        }

        quizmanual.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (quiz_manual.speechani.isRunning()) {
                    quiz_manual.speechani.stop();
                }
                quizmanual.reset();
                quizmanual=MediaPlayer.create(quiz_service.this,R.raw.quiz_manual);
            }
        });

        return START_NOT_STICKY;

    }
}
