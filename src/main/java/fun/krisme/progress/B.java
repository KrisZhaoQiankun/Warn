package fun.krisme.progress;

import fun.krisme.entity.Result;
import fun.krisme.util.ReadFiledata;

import java.io.File;

/**
 * 从txt文本中读取信息，发送到server端
 */
public class B {

    public static ReadFiledata readFiledata;
    public static ClientSimple clientSimple;
    public void read(int skiplength){
        readFiledata = new ReadFiledata();
        clientSimple = new ClientSimple();
        File file = new File("G:/test.txt");
        //从txt文本中读取数据
        //数据封装成result对象，对象中有data,row
        Result result = readFiledata.txt2String(file, skiplength, 14);
        System.out.println("B:"+result.getLength());
        //将数据发送到服务器端
        clientSimple.send(result.getData(),8080,"localhost");
        try {
//            进程睡眠5秒钟继续读取
            Thread.sleep(5000);

            read(result.getLength());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.read(0);
//        try {
//            Thread.sleep(5000);
//            read = b.read(read);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

}
