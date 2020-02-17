package com.jhhg.nova.contextclassloader;

/**
 * @author : Lyn
 * @version V1.0
 * @Project: jvm-classloader
 * @Package com.jhhg.nova.contextclassloader
 * @Description: TODO
 * @date Date : 2020-02-17 下午 03:48
 * @copyright http://www.jhhg.net.cn/
 */
public class ContextClassLoader {

    /**每个类都会使用自己的类加载器（也就是加载自身的那个类加载器）来加载它所引用到的其他类*/

    /**
     * 线程上下文类加载器
     * Thread类中有getContextClassLoader()和setContextClassLoader(ClassLoader cl)分别用来获取和设置线程的上下文类加载器
     *如果没有通过setContextClassLoader(ClassLoader cl)来进行设置的话，线程将继承它的父线程的类加载器。 Java线程的初始类加载器
     * 是系统类加载器，在线程运行中可以使用该类加载器来加载相关资源
     *
     *
     *SPI (Service Provider Interface)
     * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classloader加载的类
     * 这就改变了父加载器不能使用子classloader或者其他没有直接父子关系的classloader加载的类的情况，也就打破了
     * 双亲委托模型
     * */
    public static void main(String[] args) {
        /***/
        System.out.println(Thread.currentThread().getContextClassLoader());
        /**Thread位于Java.lang包，所以有bootstrap类加载器来加载*/
        System.out.println(Thread.class.getClassLoader());
    }
}
