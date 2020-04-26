package cn.hello.jay.practice.nio.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 周健以
 * @Date 2020年03月23日
 */
public class SelectorServer {

    public static void mainReplace(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel server = ServerSocketChannel.open();
        server.socket().bind(new InetSocketAddress(8080));

        // 将其注册到Selector中，监听OP_ACCEPT事件
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }

            Set<SelectionKey> readyKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    // 有已经接受的新的到服务器的连接
                    SocketChannel socketChannel = server.accept();

                    // 有新的连接并不代表这个通道就有数据
                    // 这里将这个新的SocketChannel注册到Selector，监听OP_READ事件，等待数据
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 有数据可读
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int num = socketChannel.read(byteBuffer);
                    if (num > 0) {
                        // 处理进来的数据...
                        System.out.println("收到数据：" + new String(byteBuffer.array()).trim());
                        ByteBuffer buffer = ByteBuffer.wrap("返回给客户端的数据...".getBytes());
                        socketChannel.write(buffer);
                    } else if (num == -1) {
                        // -1代表连接已经关闭
                        socketChannel.close();
                    }
                }
            }
        }
    }
}
