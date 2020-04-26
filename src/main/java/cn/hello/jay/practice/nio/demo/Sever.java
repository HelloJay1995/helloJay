package cn.hello.jay.practice.nio.demo;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 服务端
 */
public class Sever {

    public static void mainReplace(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 监听8080端口进来的TCP链接
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while (true) {
            // 这里会阻塞，直到有一个请求连接进来
            SocketChannel socketChannel = serverSocketChannel.accept();

            // 开启一个新的线程来处理这个请求，然后在while循环中继续监听8080端口
            SocketHandler handler = new SocketHandler(socketChannel);
            new Thread(handler).start();
        }
    }

    private static class SocketHandler implements Runnable {

        private SocketChannel socketChannel;

        public SocketHandler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 将请求数据读入Buffer中
            int num;
            try {
                while ((num = socketChannel.read(buffer)) > 0) {
                    // 读取Buffer内容之前先flip一下
                    buffer.flip();

                    // 提取Buffer中的数据
                    byte[] bytes = new byte[num];
                    buffer.get(bytes);

                    String re = new String(bytes, "UTF-8");
                    System.out.println("收到请求：" + re);

                    // 回应客户端
                    ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + re).getBytes());
                    socketChannel.write(writeBuffer);

                    buffer.clear();
                }
            } catch (IOException e) {
                IOUtils.closeQuietly(socketChannel);
            }
        }
    }
}
