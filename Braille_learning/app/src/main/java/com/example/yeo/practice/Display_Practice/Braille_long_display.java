package com.example.yeo.practice.Display_Practice;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Vibrator;
import android.view.View;

import com.example.yeo.practice.Braille_data.dot_word;
import com.example.yeo.practice.WHclass;

import java.util.Random;

/**
 * Created by yoonc on 2016-07-25.
 */
public class Braille_long_display extends View {
/*
4칸 이상의 점자를 화면에 출력해주는 클래스
4칸부터 7칸까지 점자를 표현할 수 있도록 설정되어 있음
 */

    public Random random;
    public int max, min=0; // 랜덤변수 최대값과 최소값
    public float width= WHclass.width; //가로
    public float height= WHclass.height; //세로
    public int x=0, y=0; // 점자를 터치할때 사용할 좌표를 저장할 변수
    public Vibrator vibrator; //진동 변수



    public int dot_count=0; // 점자의 칸 수를 저장하는 변수


    //점자를 출력하기 위한 화면의 좌표값을 미리 선언하였고, 돌출점자와 비돌출점자의 크기를 미리 선언하였음
    public float width1=width*(float)0.05,width2=width*(float)0.15,width3=width*(float)0.3,width4=width*(float)0.4,width5=width*(float)0.55,width6=width*(float)0.65,width7=width*(float)0.8, width8=width*(float)0.9, width9=width*(float)1.05, width10=width*(float)1.15, width11=width*(float)1.3, width12=width*(float)1.4, width13=width*(float)1.55, width14=width*(float)1.65;
    public float height1=width*(float)0.75,height2=width*(float)0.85,height3=width*(float)0.95;

    public float minicircle=width*(float)0.01, bigcircle= width*(float)0.049; // 비돌출점자와 돌출점자 메크로



    //점자를 출력하는 좌표값들을 배열에 저장함
    public float width_7[][]={{width1,width2,width3,width4,width5,width6,width7,width8,width9,width10,width11,width12,width13,width14},
            {width1,width2,width3,width4,width5,width6,width7,width8,width9,width10,width11,width12,width13,width14},
            {width1,width2,width3,width4,width5,width6,width7,width8,width9,width10,width11,width12,width13,width14}};
    public float height_7[][]={{height1,height1,height1,height1,height1,height1,height1,height1,height1,height1,height1,height1,height1,height1},
            {height2,height2,height2,height2,height2,height2,height2,height2,height2,height2,height2,height2,height2,height2},
            {height3,height3,height3,height3,height3,height3,height3,height3,height3,height3,height3,height3,height3,height3}};

    public static float target7_width[][] = new float[3][14]; //돌출된 점자의 x 좌표값을 저장하는 배열 변수
    public static float target7_height[][] = new float[3][14]; //돌출된 점자의 y 좌표값을 저장하는 배열 변수
    public static float notarget7_width[][] = new float[3][14]; //비돌출 점자의 x 좌표값을 저장하는 배열 변수
    public static float notarget7_height[][] =new float[3][14]; //비돌출 점자의 y 좌표값을 저장하는 배열 변수
    public static int text_7[][] = new int[3][14]; // 7칸의 점자를 저장하는 배열 변수. 점자 배열정보가 담긴 클래스로부터 불러온 점자를 해당 배열변수에 저장함
    public static String textname_7;// 불러온 점자가 의미하는 글자를 저장하는 변수

    static public int page=0; // 현재 점자 학습 page를 저장하는 변수

    public void MyView3_init(){ //화면 초기화 함수. 화면이 이동될 때 점자를 다시 그려줌.

        for(int i=0 ; i<3; i++){ // 돌출점자와 비돌출점자의 x,y값을 저장하는 배열변수를 초기화함
            for(int j=0 ; j<14; j++) {
                target7_width[i][j] = 0;
                target7_height[i][j] = 0;
                notarget7_width[i][j] = 0;
                notarget7_height[i][j] = 0;
            }
        }


        page = random.nextInt(max) + min;
        dot_count = dot_word.letter_dot_count.get(page);

        if(dot_count==1) { //점자가 6개일때, 즉 1칸 일때,
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    text_7[i][j] = dot_word.letter_Array.get(page)[i][j];
                    textname_7 = dot_word.letter_name.get(page);
                }
            }
        }
        else if(dot_count==2) { //점자가 12개일때, 즉 2칸일 때
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    text_7[i][j] = dot_word.letter_Array.get(page)[i][j];
                    textname_7 = dot_word.letter_name.get(page);
                }
            }
        }
        else if(dot_count==3) { //점자가 18개일때, 즉 3칸일 때
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    text_7[i][j] = dot_word.letter_Array.get(page)[i][j];
                    textname_7 = dot_word.letter_name.get(page);
                }
            }
        }
        else if(dot_count==4){ //점자가 24개일 때, 즉 4칸일 때
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 8; j++) {
                    text_7[i][j] = dot_word.letter_Array.get(page)[i][j];
                    textname_7 = dot_word.letter_name.get(page);
                }
            }
        }
        else if(dot_count==5){ //점자가 30개일 때, 즉 5칸일 때
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 10; j++) {
                    text_7[i][j] = dot_word.letter_Array.get(page)[i][j];
                    textname_7 = dot_word.letter_name.get(page);
                }
            }
        }
        else if(dot_count==6){ //점자가 36개일 때, 즉 6칸일 때
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 12; j++) {
                    text_7[i][j] = dot_word.letter_Array.get(page)[i][j];
                    textname_7 = dot_word.letter_name.get(page);
                }
            }
        }
        else if(dot_count==7){ //점자가 42개일 때, 즉 7칸일 때
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 14; j++) {
                    text_7[i][j] = dot_word.letter_Array.get(page)[i][j];
                    textname_7 = dot_word.letter_name.get(page);
                }
            }
        }
    }

    public Braille_long_display(Context context) {
        super(context);
        max = dot_word.wordcount;
        random = new Random();
        MyView3_init();

        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE); //점자의 색을 지정
        paint.setTextSize(width*(float)0.21); //점자를 의미하는 글자의 크기를 지정
        paint.setAntiAlias(true); // 점자의 표면을 부드럽게 그려줌

        switch(dot_count) {
            case 2: //점자의 칸수가 2칸일 경우 글자의 길이에 따라 글자의 출력위치를 조정함
                if(textname_7.length() <=1)
                    canvas.drawText(textname_7, height * (float) 0.45, width * (float) 0.3, paint);
                else if(textname_7.length() <=2)
                    canvas.drawText(textname_7, height * (float) 0.4, width * (float) 0.3, paint);
                else if(textname_7.length() <=3)
                    canvas.drawText(textname_7, height * (float) 0.35, width * (float) 0.3, paint);
                else if(textname_7.length() <=4)
                    canvas.drawText(textname_7, height * (float) 0.3, width * (float) 0.3, paint);

                for(int i = 0; i<3 ; i++){
                    for(int j=0 ; j<4 ; j++){
                        if(text_7[i][j]==0)
                            canvas.drawCircle(width_7[i][j],height_7[i][j],minicircle,paint);
                        else {
                            canvas.drawCircle(width_7[i][j],height_7[i][j],bigcircle,paint);
                            target7_width[i][j] = width_7[i][j];
                            target7_height[i][j] = height_7[i][j];
                        }
                        notarget7_width[i][j] = width_7[i][j];
                        notarget7_height[i][j] = height_7[i][j];
                    }
                }
                break;

            case 3: //점자의 칸수가 3칸일 경우 글자의 길이에 따라 글자의 출력위치를 조정함
                if(textname_7.length() <=1)
                    canvas.drawText(textname_7, height * (float) 0.45, width * (float) 0.3, paint);
                else if(textname_7.length() <=2)
                    canvas.drawText(textname_7, height * (float) 0.4, width * (float) 0.3, paint);
                else if(textname_7.length() <=3)
                    canvas.drawText(textname_7, height * (float) 0.35, width * (float) 0.3, paint);
                else if(textname_7.length() <=4)
                    canvas.drawText(textname_7, height * (float) 0.3, width * (float) 0.3, paint);
                for(int i = 0; i<3 ; i++){
                    for(int j=0 ; j<6 ; j++){
                        if(text_7[i][j]==0)
                            canvas.drawCircle(width_7[i][j],height_7[i][j],minicircle,paint);
                        else {
                            canvas.drawCircle(width_7[i][j],height_7[i][j],bigcircle,paint);
                            target7_width[i][j] = width_7[i][j];
                            target7_height[i][j] = height_7[i][j];
                        }
                        notarget7_width[i][j] = width_7[i][j];
                        notarget7_height[i][j] = height_7[i][j];

                    }
                }
                break;

            case 4: //점자의 칸수가 4칸일 경우 글자의 길이에 따라 글자의 출력위치를 조정함
                if(textname_7.length() <=1)
                    canvas.drawText(textname_7, height * (float) 0.45, width * (float) 0.3, paint);
                else if(textname_7.length() <=2)
                    canvas.drawText(textname_7, height * (float) 0.4, width * (float) 0.3, paint);
                else if(textname_7.length() <=3)
                    canvas.drawText(textname_7, height * (float) 0.35, width * (float) 0.3, paint);
                else if(textname_7.length() <=4)
                    canvas.drawText(textname_7, height * (float) 0.3, width * (float) 0.3, paint);
                for(int i = 0; i<3 ; i++){
                    for(int j=0 ; j<8 ; j++){
                        if(text_7[i][j]==0)
                            canvas.drawCircle(width_7[i][j],height_7[i][j],minicircle,paint);
                        else {
                            canvas.drawCircle(width_7[i][j],height_7[i][j],bigcircle,paint);
                            target7_width[i][j] = width_7[i][j];
                            target7_height[i][j] = height_7[i][j];
                        }
                        notarget7_width[i][j] = width_7[i][j];
                        notarget7_height[i][j] = height_7[i][j];

                    }
                }
                break;

            case 5://점자의 칸수가 5칸일 경우 글자의 길이에 따라 글자의 출력위치를 조정함
                if(textname_7.length() <=1)
                    canvas.drawText(textname_7, height * (float) 0.45, width * (float) 0.3, paint);
                else if(textname_7.length() <=2)
                    canvas.drawText(textname_7, height * (float) 0.4, width * (float) 0.3, paint);
                else if(textname_7.length() <=3)
                    canvas.drawText(textname_7, height * (float) 0.35, width * (float) 0.3, paint);
                else if(textname_7.length() <=4)
                    canvas.drawText(textname_7, height * (float) 0.3, width * (float) 0.3, paint);
                for(int i = 0; i<3 ; i++){
                    for(int j=0 ; j<10 ; j++){
                        if(text_7[i][j]==0)
                            canvas.drawCircle(width_7[i][j],height_7[i][j],minicircle,paint);
                        else {
                            canvas.drawCircle(width_7[i][j],height_7[i][j],bigcircle,paint);
                            target7_width[i][j] = width_7[i][j];
                            target7_height[i][j] = height_7[i][j];
                        }
                        notarget7_width[i][j] = width_7[i][j];
                        notarget7_height[i][j] = height_7[i][j];
                    }
                }
                break;


            case 6:  //점자의 칸수가 6칸일 경우 글자의 길이에 따라 글자의 출력위치를 조정함
                if(textname_7.length() <=1)
                    canvas.drawText(textname_7, height * (float) 0.45, width * (float) 0.3, paint);
                else if(textname_7.length() <=2)
                    canvas.drawText(textname_7, height * (float) 0.4, width * (float) 0.3, paint);
                else if(textname_7.length() <=3)
                    canvas.drawText(textname_7, height * (float) 0.35, width * (float) 0.3, paint);
                else if(textname_7.length() <=4)
                    canvas.drawText(textname_7, height * (float) 0.3, width * (float) 0.3, paint);

                for(int i = 0; i<3 ; i++){
                    for(int j=0 ; j<12 ; j++){
                        if(text_7[i][j]==0)
                            canvas.drawCircle(width_7[i][j],height_7[i][j],minicircle,paint);
                        else {
                            canvas.drawCircle(width_7[i][j],height_7[i][j],bigcircle,paint);
                            target7_width[i][j] = width_7[i][j];
                            target7_height[i][j] = height_7[i][j];
                        }
                        notarget7_width[i][j] = width_7[i][j];
                        notarget7_height[i][j] = height_7[i][j];

                    }
                }
                break;

            case 7: //점자의 칸수가 7칸일 경우 글자의 길이에 따라 글자의 출력위치를 조정함
                if(textname_7.length() <=1)
                    canvas.drawText(textname_7, height * (float) 0.45, width * (float) 0.3, paint);
                else if(textname_7.length() <=2)
                    canvas.drawText(textname_7, height * (float) 0.4, width * (float) 0.3, paint);
                else if(textname_7.length() <=3)
                    canvas.drawText(textname_7, height * (float) 0.35, width * (float) 0.3, paint);
                else if(textname_7.length() <=4)
                    canvas.drawText(textname_7, height * (float) 0.3, width * (float) 0.3, paint);
                for(int i = 0; i<3 ; i++){
                    for(int j=0 ; j<14 ; j++){
                        if(text_7[i][j]==0)
                            canvas.drawCircle(width_7[i][j],height_7[i][j],minicircle,paint);
                        else {
                            canvas.drawCircle(width_7[i][j],height_7[i][j],bigcircle,paint);
                            target7_width[i][j] = width_7[i][j];
                            target7_height[i][j] = height_7[i][j];
                        }
                        notarget7_width[i][j] = width_7[i][j];
                        notarget7_height[i][j] = height_7[i][j];

                    }
                }
                break;
        }
        if(x!=0&&y!=0) //현재 손가락이 터치하고 있는 위치에 동그라미를 그려줌
            canvas.drawCircle(x, y,bigcircle, paint); // 동그라미 그림
    }
}