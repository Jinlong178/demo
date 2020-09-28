package com.example.demo.demo.controller;

import com.example.demo.demo.model.Student;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author JinLong
 * @Date 2019/9/2 16:32
 * @Version 1.0
 */
public class StudentApi {
    public static volatile Boolean flag=false;
    private final static String A="yyyy-MM-dd";//日期格式
//    public static void main(String [] args) throws ParseException {
//        String num ="123456789";
//        String right = StringUtils.right(num, 3);
//        System.out.println(right);
//        String leftPad = StringUtils.leftPad(right, StringUtils.length(num), "*");
//        System.out.println(leftPad);
//        String s = StringUtils.removeStart(leftPad, "***");
//        String concat = StringUtils.left(num, 3).concat(s);
//        System.out.println(concat);
//        SimpleDateFormat sdf = new SimpleDateFormat(A);//格式时间对象
//        String text = "*-*-*";
//        Date date = sdf.parse(text);
//        System.out.println(date);
//    }

    public static void main(String [] args) throws InterruptedException {
        Thread thread1=new Thread(()->{
            for(;;){
                System.out.println(flag);
            }

        });
        Thread thread2=new Thread(()->{
            for(;;){
                flag=true;
            }

        });
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }


}
