package com.jhhg.nova.classloader;

/***
 * @ClassName: ClassLoaderCompare
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/15 下午12:18
 * @version : V1.0
 */
public class ClassLoaderCompare {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class claxx = classLoader.loadClass("com.jhhg.nova.classloader.cl");
        System.out.println(claxx);
        System.out.println("-----------------------");
        Class clazz = Class.forName("com.jhhg.nova.classloader.cl");
        System.out.println(clazz);
    }
}

class cl {
    static {
        System.out.println("cl class has been loaded!");
    }
}