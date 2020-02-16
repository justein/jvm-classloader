package com.jhhg.nova.classloader;

/***
 * @ClassName: AwsomeBlock
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/15 上午10:29
 * @version : V1.0
 */
public class AwsomeBlock {

    public static void main(String[] args) {
        new A();
        new A();
    }
}

class A {

    {
        System.out.println("that's awsome!");
    }

    public A() {
        System.out.println("A");
    }
}
