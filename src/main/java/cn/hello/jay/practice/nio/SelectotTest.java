package cn.hello.jay.practice.nio;


import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 周健以
 * @Date 2019年08月27日
 */
public class SelectotTest {

    public static void mainReplace(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();

        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
            }
        }
    }
}
