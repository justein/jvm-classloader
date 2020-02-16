package com.jhhg.nova.classloader;

import sun.security.krb5.internal.PAData;

import java.io.*;

/***
 * @ClassName: MyClassLoader
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/16 上午11:14
 * @version : V1.0
 */
public class MyClassLoader extends ClassLoader {

    private static final String FILE_EXT = ".class";

    private String classloaderName;

    private String classPath;

    public MyClassLoader(String classloaderName) {
        /**将系统类加载器作为该加载器的父加载器*/
        super();
        this.classloaderName = classloaderName;
    }

    public MyClassLoader(String classloaderName, ClassLoader parentClassLoader) {
        super(parentClassLoader);
        this.classloaderName = classloaderName;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassloader1 = new MyClassLoader("myclassloader1");
        /**MyClassLoader的父加载器是AppClassLoader，将委托它去加载类，它加载的范围是classpath
         * 这里将classloader的加载路径设置为桌面，但加载的时候，首先还是会委托父加载器去加载
         * 如果classpath中能找到要加载的class文件，自然就由父类加载器去加载了。如果把要加载的class文件
         * 从classpath删除掉的话，父类加载器加载不到，自然就交给这个自定义的类加载器去加载了，所以findCLass
         * 方法就会执行了
         * */
        myClassloader1.setClassPath("/Users/Lyn/Desktop/");
        Class clazz = myClassloader1.loadClass("com.jhhg.nova.classloader.AwsomeBlock");
        System.out.println("class: "+clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object.getClass().getClassLoader());

        /**这里，将目标类的class文件从classpath中删掉，加载路径设置为桌面。重新生成了一个类加载器
         * 这时候居然能加载成功。上面的classloader1加载时，因为AppClassloader加载不到，所以交给自定义的
         * 这个加载器去加载，加载成功了。
         * 下面这个classloader2，加载的时候跟上面一样，最终都是自己去加载，所以也会执行加载逻辑
         * 但我们看到同一份字节码生成出来的class是不一样的，这是因为这两个类加载器对象的命名空间不一样。
         *
         * */
        //MyClassLoader myClassloader2 = new MyClassLoader("myclassloader2");
        /**如果在new classloader2的时候，将classloader1作为它的父加载器，那么classloader2的父就变成了classloader1*/
        MyClassLoader myClassloader2 = new MyClassLoader("myclassloader2",myClassloader1);
        myClassloader2.setClassPath("/Users/Lyn/Desktop/");
        Class clazz2 = myClassloader2.loadClass("com.jhhg.nova.classloader.AwsomeBlock");
        System.out.println("class: "+clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2.getClass().getClassLoader());
    }

    /**自定义类加载器，最重要的就是覆写findClass这个方法，有下面两点需要注意
     * 1、父类中，这个方法只是抛出了一个异常，所以具体find行为要在子类中实现；
     * 2、我们自己实现的类加载器中，没有显示地调用findClass这个方法，而是在父类的loadClass方法中调用的。
     * */
    public Class<?> findClass(String className) {

        System.out.println("MyClassloader invoked");
        System.out.println("class loader name: "+classloaderName);
        byte[] classByte = this.loadClassData(className);
        /**通过类的二进制数据构造class的过程，也是通过调用父类的defineClass方法实现的*/
        Class myClass = defineClass(className, classByte, 0 ,classByte.length);
        return myClass;
    }

    private byte[] loadClassData(String packageAndClassName) {
        byte[] data = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        packageAndClassName = packageAndClassName.replace(".","/");

        try {
            inputStream = new FileInputStream(new File(classPath+packageAndClassName+FILE_EXT));
            /**忘记初始化了，妈蛋*/
            byteArrayOutputStream = new ByteArrayOutputStream();
            int ch;

            while (-1 != (ch = inputStream.read())) {
               byteArrayOutputStream.write(ch);
            }

            data = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return data;
    }
}
