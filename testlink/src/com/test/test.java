package com.test;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-16
 * Time: 上午9:28
 * To change this template use File | Settings | File Templates.
 */
public class test {
    static int v1=3;
    static int v2=4;
    public static void main(String[] args) {


       test test1=new test();
        test1.xx(v1,v2);
        System.out.println(v1);
    }
    public void xx(int s,int a){

        s=1;
        a=2;
    }
}
