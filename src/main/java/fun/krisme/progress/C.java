package fun.krisme.progress;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 监控A、B软件
 */
public class C {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                a.storage();
//                  a.test();
            }
        },0,1000);
//        b.read();
    }

}
