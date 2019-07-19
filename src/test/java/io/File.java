package io;

import fun.krisme.util.SendMail;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class File {

    @Test
    public void read(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("G:\\test.txt"));
            br.skip(8);
            System.out.println(br.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void write(){
        boolean loop = true;

        String data[] = new String[13];
        data[0] = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()).toString();
        data[1] = "19.20";
        data[2] = "19.20";
        data[3] = "19.20";
        data[4] = "19.20";
        data[5] = "19.20";
        data[6] = "19.20";
        data[7] = "19.20";
        data[8] = "19.20";
        data[9] = "19.20";
        data[10] = "19.20";
        data[11] = "19.20";
        data[12] = "19.20";

        FileWriter fw = null;
        try {
            fw = new FileWriter("G:\\test.txt",true);
//            while (loop){
//                fw.write(a+"\t");
//            }
//            Timer timer = new Timer();
//            timer.schedule();
            for (int i = 0; i < 13; i++) {
                fw.write(data[i]+"\t");
            }
            fw.write("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void writeeverysecond(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("d");
            }
        },1000,1000);//1秒
    }

    @Test
    public void random(){
        double d = 1.2345;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String str = decimalFormat.format(d);
        System.out.println(str);

    }

    @Test
    public void test1(){
//        double a = 19.201;
//        double b = 19.202;
//        BigDecimal decimal= new BigDecimal(Double.toString(a)).add(new BigDecimal(Double.toString(b)));
//        System.out.println(decimal);
//        BigDecimal c[] = new BigDecimal[2];
//        c[0] = new BigDecimal(Double.toString(a));
//        c[1] = new BigDecimal(Double.toString(b));
//
//        System.out.println(c[0]);
//        System.out.println(c[1]);
//        System.out.println(c[0].add(c[1]));


//        BigDecimal data[] = new BigDecimal[3];
//        data[0] = new BigDecimal(Double.toString(19.201));
//        data[1] = new BigDecimal(Double.toString(19.201));
//        data[2] = new BigDecimal(Double.toString(19.201));
//        BigDecimal decimal1 = new BigDecimal(Double.toString(0.000));
//        System.out.println(data[0]);
//        System.out.println(data[1]);
//        System.out.println(data[2]);
//        for (int i = 0; i < 3; i++) {
//            decimal1.add(data[i]);
////            System.out.println(data[i]);
////            System.out.println(data[i]);
//            System.out.println(decimal1);
//        }
//        System.out.println(decimal1);


//        float a[] = new float[3];
//        a[0] = 19.223f;
//        a[1] = 19.223f;
//        a[2] = 19.223f;
//        System.out.println(a[1]);
//        float b = 0.000f;
//        for (int i = 0; i < 3; i++) {
//            b+=a[i];
//        }
//        System.out.println(b);

        double a[] = new double[13];
        a[0] = 19.223;
        a[1] = 19.223;
        a[2] = 19.223;
        a[3] = 19.223;
        a[4] = 19.223;
        a[5] = 19.223;
        a[6] = 19.223;
        a[7] = 19.223;
        a[8] = 19.223;
        a[9] = 19.223;
        a[10] = 19.223;
        a[11] = 19.223;
        a[12] = 19.223;
        System.out.println(a[1]);
        float b = 0.000f;
        for (int i = 0; i < 13; i++) {
            b+=a[i];
        }
        BigDecimal bg = new BigDecimal(b);
        double f1 = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);


//        double a = 19.20;
//        System.out.println(a);
    }

//    问题所在double a = 19.20,数据不能显示为19.20

    @Test
    public void test(){
        BigDecimal data[] = new BigDecimal[3];
        data[0] = new BigDecimal(Double.toString(19.201));
        data[1] = new BigDecimal(Double.toString(19.201));
        data[2] = new BigDecimal(Double.toString(19.201));
        BigDecimal decimal = new BigDecimal(Double.toString(0.000));
        decimal.add(data[0]).add(data[1]).add(data[2]);
        System.out.println(data[0].add(data[1].add(data[2].add(data[1].add(data[1].add(data[1].add(data[2].add(data[2].add(data[2].add(data[2].add(data[1].add(data[1].add(data[1])))))))))))));
        System.out.println(data[1]);
    }

    @Test
    public void randomgenerate(){
        double  a = new Random().nextDouble()*12+94;
        BigDecimal bg = new BigDecimal(a);
        double f1 = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }

    //问题所在：是不是所有的double类型相加所产生的小数点后多于的位数经过BigDecimal bg = new BigDecimal(a);
    //        double f1 = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
//    处理后和一开始就将double类型转换为bigdemical然后add后的效果是一样的
//    采用办法：第一种


    @Test
    public void sendmail(){
        SendMail sendMail = new SendMail();
        try {

            sendMail.sendmail();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
