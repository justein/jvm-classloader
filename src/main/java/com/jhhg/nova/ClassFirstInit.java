package com.jhhg.nova;

/***
 * @ClassName: ClassFirstInit
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/9 下午4:53
 * @version : V1.0
 */
public class ClassFirstInit {

    public static void main(String[] args) {
        Init init = new Init();
        System.out.println("========");
        Init init1 = new Init();
    }
}

class Init {

    static {
        System.out.println("Init class static block invoke");
    }
}
