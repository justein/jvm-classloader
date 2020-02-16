package com.jhhg.nova.classloader;

/***
 * @ClassName: ClassLoadTest
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/11 上午11:02
 * @version : V1.0
 */
public class ClassLoadTest {

    public static void main(String[] args) {
        System.out.println(Child.ap);
    }
}

class Parent {
    public static int ap = 1;

    static {
        System.out.println("Class Parent static block invoke.");
    }
}

class Child extends Parent {
    public static int ac = 2;
    static {
        System.out.println("Child class static block invoke.");
    }
}