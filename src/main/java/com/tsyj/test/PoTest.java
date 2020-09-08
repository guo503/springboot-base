package com.tsyj.test;

/**
 * @description:
 * @author: guos
 * @date: 2020/3/4 12:02
 **/
public class PoTest {

    public static void main(String[] args) {
        //sxh();
        fblqsl();
    }

    public static void sxh() {
        int count = 0;
        int a, b, c;
        for (int i = 101; i < 1000; i++) {
            a = i / 100;
            //b = (i - (i / 100) * 100 - (i % 10)) / 10;
            b = i / 10 % 10;
            c = i % 10;
            //System.out.println("a= " + a + ",b= " + b + ",c= " + c);
            if ((a * a * a + b * b * b + c * c * c) == i) {
                System.out.println(++count + ": " + i);
            }
        }
    }


    public static void fblqsl() {
        int f1 = 1, f2 = 1, f;
        int M = 30;
        System.out.println(f1);
        System.out.println(f2);
        for (int i = 3; i < M; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println(f2);
        }
    }
}
