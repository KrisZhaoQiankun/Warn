package fun.krisme.util;

import fun.krisme.entity.Result;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 此方法
 */

public class ReadFiledata {
    public static Result txt2String(File file, int skiplength, int length){
        StringBuilder result = new StringBuilder();
        Result res = new Result();
//        int row = 0;
        int rowlength = 0;
        int rowlengthold = skiplength;
        try{
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.skip(skiplength);
            //对skip方法的代替
//            int r = 0;
//            while(r<ro){
//                r++;
//                br.readLine();
//            }

            String s = null;
            //使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
//                row++;
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        rowlength = result.length();
        if (rowlength==0){
            rowlength = rowlengthold;
        }
        res.setData(result.toString());
        res.setLength(rowlength);
        return res;
    }

    public static void main(String[] args){
        File file = new File("G:/test.txt");
        System.out.println(txt2String(file,120,14));
    }
}