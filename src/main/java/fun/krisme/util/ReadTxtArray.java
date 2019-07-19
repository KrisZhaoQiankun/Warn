package fun.krisme.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取txt中一行的数据，并将其存入数组
 */
public class ReadTxtArray {

    /**
     *
     * @param skiplength 要跳过的长度-一行的长度是120
     * @param length 一行的数据个数
     * @param addr 要读取txt的地址
     * @return
     */
    public String[] read(int skiplength,int length,String addr){
        BufferedReader br = null;
        String data[] = new String[length];
        try {
            br = new BufferedReader(new FileReader(addr));
            br.skip(skiplength);
            String line;
            while ((line = br.readLine()) != null){
                String[] temp = line.split("\t");
                for (int j = 0; j < temp.length; j++) {
                    data[j] = temp[j];
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) {
        ReadTxtArray readTxtArray = new ReadTxtArray();
        String[] da = readTxtArray.read(120,14,"G:\\test.txt");
        for (String de:da){
            System.out.println(de);
        }
    }
}
