package com.jhhg.nova.classloader;

/***
 * @ClassName: TestStaticFinal
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/15 上午11:18
 * @version : V1.0
 */
public class TestStaticFinal {

    public static void main(String[] args) {
        System.out.println(Static.x);
    }
}

class Static {
    public static final int x = 3;

    static {
        System.out.println("Static static block ");
    }
}
