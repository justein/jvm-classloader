package com.jhhg.nova;

/***
 * @ClassName: FinalStaticTest
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/9 下午3:13
 * @version : V1.0
 */
public class FinalStaticTest {

    public static void main(String[] args) {
        System.out.println(Final.s);
    }
}

class Final {

    static final String str = "hello world";

    static final int s = 1;

    static {
        System.out.println("Final class static block invoke");
    }
}
