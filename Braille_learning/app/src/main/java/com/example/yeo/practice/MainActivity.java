package com.example.yeo.practice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.yeo.practice.menu.Menu_Tutorial;
import com.example.yeo.practice.menu.Menu_main_service;
import com.example.yeo.practice.tutorial.Tutorial_basic_practice;
import com.example.yeo.practice.tutorial.Tutorial_dot_lecture;
import com.example.yeo.practice.tutorial.Tutorial_dot_practice;
import com.example.yeo.practice.tutorial.Tutorial_master_practice;
import com.example.yeo.practice.tutorial.Tutorial_quiz;
import com.example.yeo.practice.tutorial.Tutorial_service;
import com.example.yeo.practice.tutorial.Tutorial_tutorial;

public class MainActivity extends FragmentActivity {
    static public float width,height;
    final static int CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;   // 스마트폰 가로 해상도
        height = size.y;  // 스마트폰 세로 해상도
        WHclass.height = height;  //WHclass height에 세로 해상도 저장
        WHclass.width = width;  //WHclass width에 가로 해상도 저장
        // WidthHeight WH = new WidthHeight(width,height);
        SharedPreferences sf= getSharedPreferences("save", 0);
        int i = sf.getInt("b", 0);
        switch(i){
            case 0:
                Intent i0 = new Intent(MainActivity.this, Menu_Tutorial.class);
                //Intent i0 = new Intent(MainActivity.this, Tutorial.class);
                startActivityForResult(i0,CODE);
                startService(new Intent(this, Menu_main_service.class)); //메뉴 음성 출력 서비스
                //startService(new Intent(this, Tutorial_service.class)); // 사용설명 서비스
                finish();
                //WHclass.db=1;
                break;
            case 1:
                Intent i1 = new Intent(MainActivity.this, Tutorial_tutorial.class);
                startActivityForResult(i1, 0);
                startService(new Intent(this, Tutorial_service.class));
                finish();
                break;
            case 2:
                Intent i2 = new Intent(MainActivity.this, Tutorial_basic_practice.class);
                startActivityForResult(i2, 0);
                finish();
                break;
            case 3:
                Intent i3 = new Intent(MainActivity.this, Tutorial_master_practice.class);
                WHclass.basicprogress[0] = 1;
                startActivityForResult(i3, 0);
                finish();
                break;
            case 4:
                Intent i4 = new Intent(MainActivity.this, Tutorial_quiz.class);
                startActivityForResult(i4, 0);
                WHclass.mainmenuprogress = true;
                finish();
                break;
            case 5:
                Intent i5 = new Intent(MainActivity.this, Tutorial_dot_lecture.class);
                startActivityForResult(i5, 0);
                startService(new Intent(this, Tutorial_service.class));
                finish();
                break;
            case 6:
                Intent i6 = new Intent(MainActivity.this, Tutorial_dot_practice.class);
                WHclass.sel = 9;
                startActivityForResult(i6, 0);
                startService(new Intent(this, Tutorial_service.class));
                finish();
                break;
            case 7:
                Intent i7 = new Intent(MainActivity.this, Menu_Tutorial.class);
                startActivityForResult(i7, 0);
                startService(new Intent(this, Tutorial_service.class));
                finish();
                break;
        }

        //Intent intent = new Intent(MainActivity.this, Menu_Tutorial.class); // 대 메뉴 사용설명서 화면
        //Intent intent = new Intent(MainActivity.this, Tutorial.class); //여자 스피커 사용설명 화면
        //startActivityForResult(intent,CODE);
        //startService(new Intent(this, Tutorial_service.class)); // 사용설명 서비스
        //startService(new Intent(this, Menu_main_service.class)); //메뉴 음성 출력 서비스
        finish();

    }

}

