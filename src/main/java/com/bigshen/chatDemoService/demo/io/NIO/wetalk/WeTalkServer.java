package com.bigshen.chatDemoService.demo.io.NIO.wetalk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import static com.bigshen.chatDemoService.demo.io.NIO.wetalk.WeTalkUtils.recvMsg;
import static com.bigshen.chatDemoService.demo.io.NIO.wetalk.WeTalkUtils.sendMsg;

/**
 * @Description:
 * @Author: BIGSHEN
 * @Date: 2019/12/28 18:07
 */
public class WeTalkServer {
    private static final String EXIT_MARK = "exit";
    private int port;

    private WeTalkServer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        //1、创建服务端套接字通道，
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2、监听端口，并等待客户端连接
        ssc.socket().bind(new InetSocketAddress(port));
        System.out.println("服务端已启动，正在监听 " + port + " 端口......");
        SocketChannel channel = ssc.accept();
        System.out.println("接受来自" + channel.getRemoteAddress().toString()
                .replace("/", "") + " 请求");
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 3、等待并接收客户端发送的消息
            String msg = recvMsg(channel);
            System.out.println("\n客户端：");
            System.out.println(msg + "\n");

            // 输入信息
            System.out.println("请输入：");
            msg = sc.nextLine();
            if (EXIT_MARK.equals(msg)) {
                //4、发送消息
                sendMsg(channel, "bye~");
                break;
            }

            // 回复客户端消息
            sendMsg(channel, msg);
        }

        // 关闭通道
        channel.close();
        ssc.close();
    }

    public static void main(String[] args) throws IOException {
        new WeTalkServer(8080).start();
    }
}
