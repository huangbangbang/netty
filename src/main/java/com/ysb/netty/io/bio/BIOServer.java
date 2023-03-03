package com.ysb.netty.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @see ServerSocket
 * @see Socket
 * @author huangbangbang
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket();
        System.out.println("server starting");
        server.bind(new InetSocketAddress(8888));

        while (true){
            System.out.println("thread info : id->"+Thread.currentThread().getId()+" name->"+Thread.currentThread().getName() );
            System.out.println("waiting to connect");
            Socket socket = server.accept();
            System.out.println("receiving a request");
            newCachedThreadPool.execute(() -> {
                handle(socket);
            });
        }


    }

    private static void handle(Socket socket) {
        System.out.println("thread info : id->"+Thread.currentThread().getId()+" name->"+Thread.currentThread().getName() );
        byte[] buf = new byte[1024*1024];
        try {
            InputStream inputStream = socket.getInputStream();
            int len;
            while ((len = inputStream.read(buf)) != -1){
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.getMessage();
        }finally {
            System.out.println("close resource");
            try {
                socket.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }

    }

}
