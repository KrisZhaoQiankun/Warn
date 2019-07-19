package fun.krisme.test;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class test1 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean loop = true;

                double data[] = new double[13];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                data[0] = 19.223;
                data[1] = 19.223;
                data[2] = 19.223;
                data[3] = 19.223;
                data[4] = 19.223;
                data[5] = 19.223;
                data[6] = 19.223;
                data[7] = 19.223;
                data[8] = 19.223;
                data[9] = 19.223;
                data[10] = 19.223;
                data[11] = 19.223;
                data[12] = 19.223;

                double a = 0.000;
                for (int i = 0; i < 13; i++) {
                    a = a + data[i];
//                    System.out.println(a);
                }
                System.out.println(a);

            }
        },1000,1000);//1秒
    }
}
