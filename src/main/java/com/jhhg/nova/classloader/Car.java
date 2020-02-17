package com.jhhg.nova.classloader;

/**
 * @author : Lyn
 * @version V1.0
 * @Project: jvm-classloader
 * @Package com.jhhg.nova.classloader
 * @Description: TODO
 * @date Date : 2020-02-17 上午 10:27
 * @copyright http://www.jhhg.net.cn/
 */
public class Car {

    public Car() {
        System.out.println("Car class is loaded by : "+this.getClass().getClassLoader());
        System.out.println("from Vehicle "+Vehicle.class);
    }
}
