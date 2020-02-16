package com.jhhg.nova.classloader;

/***
 * @ClassName: ClassInterfaceTest
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/15 上午10:39
 * @version : V1.0
 */
public class ClassInterfaceTest {

    public static void main(String[] args) {
        System.out.println(Child1.a);
    }
}

interface ParentInter {

    Thread thread = new Thread() {
        {
            System.out.println("In ParentInterface");
        }
    };
}

class Child1 implements ParentInter{
    public static int a = 1;
}
