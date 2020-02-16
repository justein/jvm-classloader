package com.jhhg.nova.classloader;

import java.net.URL;
import java.util.Enumeration;

/***
 * @ClassName: ClassLoaderResource
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/16 上午10:23
 * @version : V1.0
 */
public class ClassLoaderResource {

    public static void main(String[] args) {
        //parseTheClassLoader();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "com/jhhg/nova/classloader/Parent.class";
        URL urls =  classLoader.getResource(resourceName);
        System.out.println(classLoader);
        System.out.println(ClassLoaderResource.class.getClassLoader());
    }

    public static void parseTheClassLoader() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null ){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}


