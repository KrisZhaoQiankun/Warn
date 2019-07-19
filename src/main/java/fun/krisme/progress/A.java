package fun.krisme.progress;

import fun.krisme.util.RandomGenerate;
import fun.krisme.util.SendMail;
import fun.krisme.util.WriteTxt;

import java.util.Timer;
import java.util.TimerTask;

public class A {
    public void storage(){
        RandomGenerate randomGenerate = new RandomGenerate();
        SendMail sendMail = new SendMail();
        WriteTxt writeTxt = new WriteTxt();
//        生成所需数据
        String[] datastr = randomGenerate.getData(14);
//        将数据插入指定位置的txt文本
        writeTxt.insert(datastr,"G:\\test.txt");
//        对于不符合规定的数值的操作
        for (int i = 1; i < datastr.length-1; i++) {
//            若数值不在规定内
            System.out.println(datastr[i]);
            if (Double.parseDouble(datastr[i])<95||Double.parseDouble(datastr[i])>105){
//                警报
                System.err.println("警报响起");
//                发送邮件至相应邮箱
                try {
//                    sendMail.sendmail();
                }catch (Exception e){
                    System.out.println("邮件发送错误"+e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        Timer timer =  new Timer();
        A a = new A();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                a.storage();
            }
        },0,1000);
    }

    public void test(){
        System.out.println("test");
    }
}
