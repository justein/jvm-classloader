package com.jhhg.nova.classloader;

import sun.misc.Launcher;

import java.util.logging.XMLFormatter;

/**
 * @author : Lyn
 * @version V1.0
 * @Project: jvm-classloader
 * @Package com.jhhg.nova.classloader
 * @Description: TODO
 * @date Date : 2020-02-17 上午 10:27
 * @copyright http://www.jhhg.net.cn/
 */
public class ClassLoaderComplicate {

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("locder1");
        myClassLoader.setClassPath("D:\\classloadertest\\");
        try {
            Class clazz = myClassLoader.loadClass("com.jhhg.nova.classloader.Vehicle");
            System.out.println("class is : "+clazz.hashCode());
            Object object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
