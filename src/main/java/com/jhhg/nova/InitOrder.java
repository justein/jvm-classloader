package com.jhhg.nova;

/***
 * @ClassName: InitOrder
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/11 上午10:17
 * @version : V1.0
 */
public class InitOrder {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println(Singleton.a);
        System.out.println(Singleton.b);
    }
}

class Singleton {

    public static int a;


    private static Singleton singleton = new Singleton();
    /**准备阶段这个方法是不会执行的*/
    private Singleton() {
        a++;
        /**此时b还没有被初始化，使用的还是准备阶段的值，是0，++操作后是1*/
        b++;
    }
    /**这里再进行初始化的时候，就把前面的值给覆盖掉了。。。*/
    public static int b = 0;
    public static Singleton getInstance() {
        return singleton;
    }
}
