package com.jhhg.nova.classloader;

/***
 * @ClassName: ParentChildReview
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/15 上午11:42
 * @version : V1.0
 */
public class ParentChildReview {

    public static void main(String[] args) {
        System.out.println(Child3.x);
        System.out.println("------------");
        Child3.doSth();
    }
}

class Parent3 {
    static int x = 10;
    static {
        System.out.println("Parent3 static block");
    }

    static void doSth() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {

    static int y = 11;

    static {
        System.out.println("Child3 static block");
    }


}
