package fun.krisme.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 向txt文本中插入String类型的数组
 */
public class WriteTxt {

    /**
     *
     * @param data 要存入的数组数据
     * @param addr 要存入数据的txt文本
     */
    public void insert(String data[],String addr){
        FileWriter fw = null;
        try {

            fw = new FileWriter(addr,true);
            for (int i = 0; i < data.length; i++) {
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
}
