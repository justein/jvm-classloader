package com.jhhg.nova.classloader;

/***
 * @ClassName: InterfaceTest
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/15 上午10:52
 * @version : V1.0
 */
public class InterfaceTest {

    public static void main(String[] args) {
        System.out.println(Likely.thread);
    }
}

interface Good {
    Thread thread = new Thread() {

        {
            System.out.println("In Good");
        }
    };
}

interface Likely extends Good {
    Thread thread = new Thread() {
        {
            System.out.println("In Likely");
        }
    };
}