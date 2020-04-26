package cn.hello.jay.practice.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 周健以
 * @Date 2019年08月30日
 */
public class NIOServer extends Thread {

    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);

            serverSocket.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                // 阻塞等待就绪的channel
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.write(Charset.defaultCharset().encode("Hello Jay"));

                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mainReplace(String[] args) {
        NIOServer server = new NIOServer();
        server.start();
    }
}
