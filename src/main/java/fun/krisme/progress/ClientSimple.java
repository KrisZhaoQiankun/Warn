package fun.krisme.progress;

import fun.krisme.util.ReadFiledata;
import fun.krisme.util.ReadTxtArray;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientSimple {
    /**
     *
     * @param data 要发送到服务端的数组
     * @param port 端口
     * @param host 主机
     */
    public void send(String data,int port,String host) {
        System.out.println("Client Start...");
            Socket socket = null;
            try {
                //创建一个流套接字并将其连接到指定主机上的指定端口号
                socket = new Socket(host,port);
//                向服务端传输数组--------
                /*ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(data);*/

//                向服务端传输字符串------
                PrintStream out = new PrintStream(socket.getOutputStream());
                out.println(data);
                out.flush();
                out.close();
            } catch (Exception e) {
                System.out.println("客户端异常:" + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        socket = null;
                        System.out.println("客户端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }

    public static void main(String[] args) {
        ReadTxtArray readTxtArray = new ReadTxtArray();
        ReadFiledata readFiledata = new ReadFiledata();
        ClientSimple clientSimple = new ClientSimple();
//        clientSimple.send(readFiledata.txt2String(new File("G:/test.txt"),120,14),8080,"localhost");
    }
}