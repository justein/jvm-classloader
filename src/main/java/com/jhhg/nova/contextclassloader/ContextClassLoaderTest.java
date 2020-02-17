package com.jhhg.nova.contextclassloader;

/**
 * @author : Lyn
 * @version V1.0
 * @Project: jvm-classloader
 * @Package com.jhhg.nova.contextclassloader
 * @Description: TODO
 * @date Date : 2020-02-17 下午 04:42
 * @copyright http://www.jhhg.net.cn/
 */
public class ContextClassLoaderTest implements Runnable{
    private Thread thread;
    public ContextClassLoaderTest() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader  = thread.getContextClassLoader();
        thread.setContextClassLoader(classLoader);
        System.out.println(classLoader.getClass());
        System.out.println(classLoader.getParent());

    }

    public static void main(String[] args) {
        ContextClassLoaderTest contextClassLoaderTest = new ContextClassLoaderTest();

    }
}
