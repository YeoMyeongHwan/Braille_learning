package com.example.yeo.practice.quiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.yeo.practice.Display_Practice.Quiz_Braille_long_practice;
import com.example.yeo.practice.Display_Practice.Quiz_Braille_short_practice;
import com.example.yeo.practice.MainActivity;
import com.example.yeo.practice.R;
import com.example.yeo.practice.*;

public class quiz_manual extends FragmentActivity {
    static AnimationDrawable speechani;
    static ImageView speechimage;
    final public static int VOWEL = 2;
    final public static int WORD= 9;
    final public static int ENTER = 0;
    public int newdrag,olddrag;
    public static int choice;
    public int y1drag,y2drag;
    public int posx1,posx2,posy1,posy2;
    public boolean enter = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_manual);
        speechimage = (ImageView) findViewById(R.id.imageView2);
        speechimage.setBackgroundResource(R.drawable.speechani);
        speechani = (AnimationDrawable) speechimage.getBackground();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View decorView = getWindow().getDecorView();
        int uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility( uiOption );


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        speechani.start();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                posx1 = (int)event.getX();
                posy1 = (int)event.getY();
                break;
            case MotionEvent.ACTION_UP:
                posx2 = (int)event.getX();
                posy2 = (int)event.getY();

                if(enter == true) {
                    if (posx2 < posx1 + 200 && posx2 > posx1 - 200 && posy1 < posy2 + 200 && posy2 > posy2 - 200) {
                        switch(choice) {
                            case 1:
                                Intent intent = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 1;
                                break;
                            case 2:
                                Intent intent2 = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent2, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 2;
                                break;
                            case 3:
                                Intent intent3 = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent3, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 3;
                                break;
                            case 4:
                                Intent intent4 = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent4, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 4;
                                break;
                            case 5:
                                Intent intent5 = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent5, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 5;
                                break;
                            case 6:
                                Intent intent6 = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent6, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 6;
                                break;
                            case 7:
                                Intent intent7 = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent7, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 7;
                                break;
                            case 8:
                                Intent intent8 = new Intent(quiz_manual.this, Quiz_Braille_short_practice.class);
                                startActivityForResult(intent8, ENTER);
                                quiz_service.question = 1;
                                WHclass.quiz_sel = 8;
                                break;
                            case 9:
                                Intent intent9 = new Intent(quiz_manual.this, Quiz_Braille_long_practice.class);
                                startActivityForResult(intent9, ENTER);
                                quiz_service.question = 1;
                                break;
                        }
                        finish();
                    }
                }
                else{
                    enter = true;
                    finish();
                }
                break;

            case MotionEvent.ACTION_POINTER_UP:  // 두번째 손가락을 떼었을 경우
                newdrag = (int)event.getX();
                y2drag = (int) event.getY();
                if (y1drag - y2drag > MainActivity.width * (float) 0.2) {
                    quiz_service.question=6;
                    startService(new Intent(this, quiz_service.class));
                    finish();
                }
            case MotionEvent.ACTION_POINTER_DOWN:
                olddrag = (int)event.getX();
                y1drag = (int) event.getY();
                break;
        }
        return true;
    }
    public void onBackPressed() {
        finish();
    }
}
