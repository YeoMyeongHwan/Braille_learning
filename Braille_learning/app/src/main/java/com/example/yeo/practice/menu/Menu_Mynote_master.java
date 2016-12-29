package com.example.yeo.practice.menu;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yeo.practice.Display_Practice.Braille_long_practice;
import com.example.yeo.practice.Display_Practice.Braille_short_practice;
import com.example.yeo.practice.MainActivity;
import com.example.yeo.practice.Menu_info;
import com.example.yeo.practice.R;
import com.example.yeo.practice.WHclass;
import com.example.yeo.practice.sound.slied;

import org.w3c.dom.Text;

//나만의 단어장 메뉴 화면

public class Menu_Mynote_master extends FragmentActivity {

    int newdrag,olddrag;
    int posx1,posx2,posy1,posy2;
    int y1drag,y2drag;
    boolean enter = true;

    int i = 0;
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
        setContentView(R.layout.activity_menu__mynote_master);






    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: //손가락 1개를 화면에 터치하였을 경우
                posx1 = (int)event.getX(); //현재 좌표의 x좌표값 저장
                posy1 = (int)event.getY(); //현재 좌표의 y좌표값 저장

                if(i>=MainActivity.braille_db.db_manager.size_count) i=0;
                i++;
                break;
            case MotionEvent.ACTION_UP: //손가락 1개를 화면에서 떨어트렸을 경우
                posx2 = (int)event.getX(); //손가락 1개를 화면에서 떨어트린 x좌표값 저장
                posy2 = (int)event.getY();  //손가락 1개를 화면에서 떨어트린 y좌표값 저장
                if(enter == true) {  //손가락 1개를 떨어트린 x,y좌표 지점에 다시 클릭이 이루어진다면 나만의 단어장으로 접속
                    if (posx2 < posx1 + WHclass.Touch_space && posx2 > posx1 - WHclass.Touch_space && posy1 < posy2 + WHclass.Touch_space && posy2 > posy2 - WHclass.Touch_space) {
                   /*     WHclass.sel =Menu_info.MENU_NOTE ;
                        Intent intent = new Intent(Menu_Mynote_master.this, Braille_long_practice.class);
                        startActivityForResult(intent, Menu_info.MENU_NOTE);*/
                    }
                }
                else    enter = true;


                break;

            case MotionEvent.ACTION_POINTER_UP:  // 두번째 손가락을 떼었을 경우
                newdrag = (int)event.getX();  // 두번째 손가락이 떨어진 지점의 x좌표값 저장
                y2drag = (int)event.getY(); // 두번째 손가락이 떨어진 지점의 y좌표값 저장
                if(olddrag-newdrag>WHclass.Drag_space) { //손가락 2개를 이용하여 오른쪽에서 왼쪽으로 드래그할 경우 다음 메뉴로 이동
                    Intent intent = new Intent(this,Menu_Mynote_basic.class);
                    startActivityForResult(intent,Menu_info.MENU_MYNOTE_BASIC);
                    Menu_main_service.menu_page = Menu_info.MENU_MYNOTE_BASIC;
                    slied.slied =Menu_info.next;
                    startService(new Intent(this, slied.class));
            //        startService(new Intent(this, Menu_main_service.class));
                    finish();
                }
                else if(newdrag-olddrag>WHclass.Drag_space) { //손가락 2개를 이용하여 왼쪽에서 오른쪽으로 드래그 할 경우 이전 메뉴로 이동
                    Intent intent = new Intent(this,Menu_Mynote_basic.class);
                    startActivityForResult(intent,Menu_info.MENU_MYNOTE_BASIC);
                    Menu_main_service.menu_page = Menu_info.MENU_MYNOTE_BASIC;
                    slied.slied = Menu_info.pre;
                    startService(new Intent(this, slied.class));
                  //  startService(new Intent(this, Menu_main_service.class));
                    finish();
                }
                else if(y2drag-y1drag> WHclass.Drag_space) { //손가락 2개를 이용하여 상단에서 하단으로 드래그할 경우 현재 메뉴의 상세정보 음성 출력
                    //              Menu_detail_contents.menu_page=4;
                    //              startService(new Intent(this, Menu_detail_contents.class));
                }else if (y1drag - y2drag > WHclass.Drag_space) { //손가락 2개를 이용하여 하단에서 상단으로 드래그할 경우 현재 메뉴를 종료
                    //             Menu_main_service.menu_page=Menu_info.MENU_TUTORIAL;
                    finish();
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:  //두번째 손가락이 화면에 터치 될 경우
                enter = false; //손가락 1개를 인지하는 화면을 잠금
                olddrag = (int)event.getX(); // 두번째 손가락이 터지된 지점의 x좌표값 저장
                y1drag = (int) event.getY(); // 두번째 손가락이 터지된 지점의 y좌표값 저장
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {  //종료키를 눌렀을 경우
        //     Menu_main_service.menu_page=Menu_info.MENU_TUTORIAL;
        finish();
    }



}