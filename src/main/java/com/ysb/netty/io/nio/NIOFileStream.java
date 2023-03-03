package com.ysb.netty.io.nio;

/**
 * @author Huang Bangbang
 * @date 2023/3/2 - 21:22
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *                
 *  file --> channel --> buffer  --> channel -->  file
 *               
 */
public class NIOFileStream {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/Users/huangbangbang/desktop/aaa.txt");
        FileChannel channel1 = fileInputStream.getChannel();
        
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/huangbangbang/desktop/bbb.txt");
        FileChannel channel2 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true){
            byteBuffer.clear();
            int read = channel1.read(byteBuffer);
            if (read == -1){
                break;
            }
            byteBuffer.flip();
            channel2.write(byteBuffer);
        }

    }
}
