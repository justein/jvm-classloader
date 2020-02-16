package com.jhhg.nova;

/***
 * @ClassName: ParentChildInit
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/8 下午5:32
 * @version : V1.0
 */
public class ParentChildInit {

    /**类的静态变量*/
    static String str = "parent_str";
    /**类的静态代码块*/
    static {
        System.out.println("Parent static block invoke.");
    }

    static void staticMethod1() {
        System.out.println("Parent static method invoke.");
    }

    public static void main(String[] args) {
        Child.staticMethod2();
    }

}

class Child extends ParentChildInit{

    /**子类的静态变量*/
    static String strChild = "child_str";
    /**子类的静态代码块*/
    static {
        System.out.println("Child static block invoke");
    }

    static void staticMethod2() {
        System.out.println("Child static method invoke.");
    }
}
