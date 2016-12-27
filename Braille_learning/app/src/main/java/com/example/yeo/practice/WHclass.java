package com.example.yeo.practice;

import android.support.v7.app.ActionBarActivity;

/**
 * Created by Yeo on 2016-08-02.
 */
public class WHclass extends ActionBarActivity {
    /*
    모든 클래스에서 사용되는 변수들을 관리하는 클래스
     */
    static public float width;
    static public float height;
    static public int sel;
    static public boolean target=false;
    static public int number = 0;
    static public int quiz_sel = 0;
    static public int tutorial_progress = 0;
    static public int tutorial_previous = -1;
    static public boolean touchevent = true;
    static public boolean mainmenuprogress = false;
    static public boolean mainmenusuccess = false;
    static public boolean basicsuccess = false;
    static public int[] basicprogress = new int[]{0,0,0,0,0,0,0};
    static public int basicprogressresult = 0;
    static public int db;

    static public float Touch_space = MainActivity.width * (float) 0.1;
    static public float Drag_space = MainActivity.width * (float) 0.2;
    static public int Strong_vibe = 250;
    static public int Weak_vibe = 50;

}
