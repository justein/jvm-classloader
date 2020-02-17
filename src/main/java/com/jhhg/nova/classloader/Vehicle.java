package com.jhhg.nova.classloader;

/**
 * @author : Lyn
 * @version V1.0
 * @Project: jvm-classloader
 * @Package com.jhhg.nova.classloader
 * @Description: TODO
 * @date Date : 2020-02-17 上午 10:28
 * @copyright http://www.jhhg.net.cn/
 */
public class Vehicle {

    public Vehicle() {
        System.out.println("Vhicle class is loaded by : "+this.getClass().getClassLoader());

        new Car();
    }
}
