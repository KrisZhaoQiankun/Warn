package fun.krisme.progress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSimple {
    public static final int port = 8080;//监听的端口号

    public static void main(String[] args) {
        System.out.println("Server...\n");
        ServerSimple server = new ServerSimple();
        server.init();
    }

    public void init() {
        try {
            //创建一个ServerSocket，这里可以指定连接请求的队列长度
            //new ServerSocket(port,3);意味着当队列中有3个连接请求是，如果Client再请求连接，就会被Server拒绝
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                //从请求队列中取出一个连接
                Socket client = serverSocket.accept();
                // 处理这次连接
                new HandlerThread(client);
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;

        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }

        public void run() {
            try {
//                接收客户端传输过来的对象或者数组------
                /*ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
                String arr[] = (String[]) oi.readObject();
                for (String da:arr){
                    System.out.println(da);
                }
                oi.close();*/

//                接收客户端传来的字符串-------
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String info;
                while ((info = input.readLine()) != null) {
                    System.out.println(info);
                }
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("服务器 run 异常: " + e.getMessage());

            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}