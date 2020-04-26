package cn.hello.jay.practice.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO实现
 *
 * @author 周健以
 * @Date 2019年08月28日
 */
public class DemoServer extends Thread {

    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(0);

            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 简化实现，不做读取，直接发送字符串
     */
    class RequestHandler extends Thread {

        private Socket socket;

        public RequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("Hello Jay");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void mainReplace(String[] args) throws IOException {
        DemoServer server = new DemoServer();
        server.start();
        Socket client = new Socket(InetAddress.getLocalHost(), server.getPort());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String data;
        while ((data = bufferedReader.readLine()) != null) {
            System.out.println(data);
        }
    }
}
