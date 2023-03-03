package com.ysb.netty.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Huang Bangbang
 * @date 2023/3/2 - 20:45
 */

/**
 *                ------
 *   string  --> |buffer| -->  file
 *               |      |
 *   string  <-- |buffer| <--  file
 *               -------
 */
public class NIOFileOutputStream {
    public static void main(String[] args) throws IOException {
        String content = "hello java";
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/huangbangbang/desktop/111.text");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(content.getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);

        File file = new File("/Users/huangbangbang/desktop/222.text");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        byteBuffer.flip();
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
    }
}
