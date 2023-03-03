package com.ysb.netty.io.nio;

import java.nio.IntBuffer;

/**
 * @author Huang Bangbang
 * @date 2023/3/1 - 22:36
 */
public class BufferTest {
    public static final int CAPACITY = 12;
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(CAPACITY) ;

        for (int i = 0;i<4;i++){
            intBuffer.put(i);
        }
        intBuffer.flip();
        System.out.println("first read ");
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
        intBuffer.flip();
        intBuffer.limit(CAPACITY);
        intBuffer.position(4);
        for (int i = 4;i<intBuffer.capacity();i++){
            intBuffer.put(i*2);
        }
        intBuffer.flip();
        intBuffer.position(4);
        System.out.println("sencod read");
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
