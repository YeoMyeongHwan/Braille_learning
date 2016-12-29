package com.example.yeo.practice.MyNote;

/**
 * Created by chanh on 2016-12-28.
 */

/*
나만의 단어장 기능을 위해 데이터베이스로부터 불러온 값을 관리하고 매칭해주는 클래스
 */
public class DB_manager {


    int MAXSIZE = 50; //나만의 단어장의 최대 갯수

    public int size_count = 0; // 사이즈를 카운트 하는 변수

    int count[] = new int [MAXSIZE]; //점자 칸의 갯수
    String name[] = new String [MAXSIZE]; //점자 이름
    String matrix1[] = new String [MAXSIZE]; // 점자 행렬의 첫번째 행
    String matrix2[] = new String [MAXSIZE]; // 점자 행렬의 두번째 행
    String matrix3[] = new String [MAXSIZE]; // 점자 행렬의 세번째 행
    int reference[] = new int [MAXSIZE]; // 점자의 주소
    int reference_index[] = new int [MAXSIZE]; //점자의 순서번호


    static public boolean MyNote_down = false; //어플리케이션이 실행되고 다운받은적이 있는지에 대한 여부

    public int My_Note_page = 0;


    DB_manager(){}

    public void DB_All_insert(int count_temp, String name_temp, String matrix1_temp, String matrix2_temp, String matrix3_temp, int reference_temp, int reference_index_temp){
        if(size_count<MAXSIZE) {
            count[size_count] = count_temp;
            name[size_count] = name_temp;
            matrix1[size_count] = matrix1_temp;
            matrix2[size_count] = matrix2_temp;
            matrix3[size_count] = matrix3_temp;
            reference[size_count] = reference_temp;
            reference_index[size_count] = reference_index_temp;
            size_count++;
        }
    }

    public int getCount(int index){
        return count[index];
    }
    public String getName(int index){
        return name[index];
    }
    public String getMatrix_1(int index){
        return matrix1[index];
    }
    public String getMatrix_2(int index){
        return matrix2[index];
    }
    public String getMatrix_3(int index){
        return matrix3[index];
    }
    public int getReference(int index){
        return reference[index];
    }
    public int getReference_index(int index){
        return reference_index[index];
    }

}
