package cn.hello.jay.practice.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 周健以
 * @Date 2019年08月27日
 */
public class ChannelTest {

    public static void mainReplace(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("/Users/hellojay/Desktop/Test.txt", "rw");
        RandomAccessFile toFile = new RandomAccessFile("/Users/hellojay/Desktop/copy.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();

        toChannel.transferFrom(fromChannel, fromChannel.position(), fromChannel.size());
        fromChannel.transferTo(toChannel.position(), toChannel.size(), toChannel);


        ByteBuffer buffer = ByteBuffer.allocate(4);

        int read = fromChannel.read(buffer);

        while (read != -1) {
            System.out.println("read:" + read);
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }

            buffer.clear();

            read = fromChannel.read(buffer);
        }

        fromFile.close();
        toFile.close();
    }
}
