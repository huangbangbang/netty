package com.ysb.netty.io;

public class Test01 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        Test01 test02 = new Test01();

        System.out.println(test01.equals(test02));
        System.out.println(test01);
        System.out.println(test02);
    }

    @Override
    public int hashCode() {
        System.out.println("比较内容");
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
    
}
