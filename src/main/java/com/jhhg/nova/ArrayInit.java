package com.jhhg.nova;

/***
 * @ClassName: ArrayInit
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/9 下午4:57
 * @version : V1.0
 */
public class ArrayInit {

    public static void main(String[] args) {
        Array[] arrays = new  Array[1];
        /**数组的类型是 [Lcom.jhhg.nova.Array; 类型是在运行期决定的，而且也不是Array类型，所以不会触发累的初始化*/
        System.out.println(arrays.getClass());
        System.out.println(arrays.getClass().getSuperclass());

        /**整型数组的类型  class [I*/
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}

class Array {

    static {
        System.out.println("Array class static block invoke");
    }
}
