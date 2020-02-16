package com.jhhg.nova;

import java.util.UUID;

/***
 * @ClassName: UUIDFinalStatic
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/9 下午4:40
 * @version : V1.0
 */
public class UUIDFinalStatic {

    public static void main(String[] args) {
        System.out.println(MyUUID.str);
    }
}

class MyUUID {

    /**因为str的值在编译期是无法确定下来的，只有在运行时才能确定，所以会触发类的初始化*/
    static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyUUID static block invoke");
    }
}
