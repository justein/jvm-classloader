package com.jhhg.nova.contextclassloader;

/**
 * @author : Lyn
 * @version V1.0
 * @Project: jvm-classloader
 * @Package com.jhhg.nova.contextclassloader
 * @Description: TODO
 * @date Date : 2020-02-17 下午 04:57
 * @copyright http://www.jhhg.net.cn/
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的使用模式——获取，使用，还原
 *
 * try｛
 * Thread.currentThread().setContextClassLoader(targetCl);
 * myMethod();//在这里边使用targetCl进行相关类的加载
 * ｝finally{
 *     Thread.currentThread().setContextClassLoader(classLoader);
 * }
 * */
public class ContextClassLoaderPattern {
    public static void main(String[] args) {
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Driver driver = (Driver) iterator.next();
            System.out.println("driver: "+driver.getClass()+", loader: "+driver.getClass().getClassLoader());
        }

        System.out.println("current thread context class loader : "+Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader class loader : "+serviceLoader.getClass().getClassLoader());
    }
}
