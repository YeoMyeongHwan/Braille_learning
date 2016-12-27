package com.example.yeo.practice.menu;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.yeo.practice.Display_Practice.Braille_short_practice;
import com.example.yeo.practice.Menu_info;
import com.example.yeo.practice.basic_practice.Initial_service;
import com.example.yeo.practice.MainActivity;
import com.example.yeo.practice.R;
import com.example.yeo.practice.WHclass;
import com.example.yeo.practice.sound.slied;


public class Menu_Initial_Consonant extends FragmentActivity {
    MediaPlayer finish;


    int newdrag,olddrag;
    int posx1,posx2,posy1,posy2;
    int y1drag,y2drag;
    boolean enter = true;
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setContentView(R.layout.activity_menu__initial__consonant);
        finish = MediaPlayer.create(Menu_Initial_Consonant.this, R.raw.basicfinish);

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

                    if (posx2 < posx1 + WHclass.Touch_space && posx2 > posx1 - WHclass.Touch_space && posy1 < posy2 + WHclass.Touch_space && posy2 > posy2 - WHclass.Touch_space) {
                        WHclass.sel=Menu_info.MENU_INITIAL;
                        Intent intent = new Intent(Menu_Initial_Consonant.this, Braille_short_practice.class);
                        startActivityForResult(intent, Menu_info.MENU_INITIAL);
                        startService(new Intent(this, Initial_service.class));
                    }
                }
                else    enter = true;


                break;

            case MotionEvent.ACTION_POINTER_UP:  // 두번째 손가락을 떼었을 경우
                newdrag = (int)event.getX();
                y2drag = (int)event.getY();
                if(olddrag-newdrag>WHclass.Drag_space) {
                    Intent intent = new Intent(this,Menu_Vowel.class);
                    startActivityForResult(intent,Menu_info.MENU_VOWEL);
                    Menu_service.menu_page = Menu_info.MENU_VOWEL;
                    slied.slied =Menu_info.next;
                    startService(new Intent(this, slied.class));
                    startService(new Intent(this, Menu_service.class));

                    finish();
                }
                else if(newdrag-olddrag>WHclass.Drag_space) {
                    Intent intent = new Intent(this,Menu_abbreviation.class);
                    startActivityForResult(intent,Menu_info.MENU_ABBREVIATION);
                    Menu_service.menu_page = Menu_info.MENU_ABBREVIATION;
                    slied.slied = Menu_info.pre;
                    startService(new Intent(this, slied.class));
                    startService(new Intent(this, Menu_service.class));
                    finish();
                }
                else if(y2drag-y1drag> WHclass.Drag_space) {
                    Menu_detail_contents.menu_page=5;
                    startService(new Intent(this, Menu_detail_contents.class));
                }else if (y1drag - y2drag > WHclass.Drag_space) {
                    finish.start();
                    finish();
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                enter = false;
                olddrag = (int)event.getX();
                y1drag = (int) event.getY();
                break;
        }
        return true;
    }
    public void onBackPressed() {
        finish.start();
        finish();
    }
}
