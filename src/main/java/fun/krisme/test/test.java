package fun.krisme.test;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean loop = true;

                BigDecimal data[] = new BigDecimal[13];
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                data[0] = new BigDecimal(Double.toString(19.201));
                data[1] = new BigDecimal(Double.toString(19.201));
                data[2] = new BigDecimal(Double.toString(19.201));
                data[3] = new BigDecimal(Double.toString(19.201));
                data[4] = new BigDecimal(Double.toString(19.201));
                data[5] = new BigDecimal(Double.toString(19.201));
                data[6] = new BigDecimal(Double.toString(19.201));
                data[7] = new BigDecimal(Double.toString(19.201));
                data[8] = new BigDecimal(Double.toString(19.201));
                data[9] = new BigDecimal(Double.toString(19.201));
                data[10] = new BigDecimal(Double.toString(19.201));
                data[11] = new BigDecimal(Double.toString(19.201));
                data[12] = new BigDecimal(Double.toString(19.201));


                double a = 0;
                DecimalFormat df = new DecimalFormat("0.000");
//                BigDecimal b1 = new BigDecimal(Double.toString(a));
                for (int i = 1;i<13;i++){
//                    a = a+Double.parseDouble(new DecimalFormat("#.00").format(Double.parseDouble(data[i])));
//                    BigDecimal b2 = new BigDecimal(Double.toString(data[i]));
//
//                    System.out.println(b1.add(b2).doubleValue());
//                    df.format(a) += df.format(data[i]);
                }
//                System.out.println(b1);

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
        },1000,1000);//1秒
    }

}
