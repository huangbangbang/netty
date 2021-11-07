package com.ysb.netty.io;

import org.openjdk.jol.info.ClassLayout;

/**
 *一个Java对象占多大空间 ?
 */
public class JOLTest {

        public static void main(String[] args) {
            // new一个A对象
            A o = new A();

            // 打印出A对象的内存空间大小
            String printable = ClassLayout.parseInstance(o).toPrintable();

            System.out.println(printable);
        }
    }

    class A {
        // 布尔型
        boolean boolean_A = false;
        boolean boolean_A2 = true;
        // 整型
        int int_b = 1;
        // 字节
        byte byte_d = 1;
        // 单精度
        float float_e = 1.0f;
        // 双精度
        double double_f = 1.0d;
        // 长整型
        long long_g = 1l;
        // 短整型
        short short_h = 1;
        // 普通对象（或者自定义对象）
        Object object_o = new Object();
        // 字符串
        String str = "123456789asdfghjkl";

        // 整型数据
        int[] array_int = {1,2,3,4,5,6,7,8,9,0};
        // 对象数组
        String[] array_str = {"1","2","3","4","","5","6","7","8"};
    }

