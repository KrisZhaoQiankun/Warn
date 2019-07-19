package fun.krisme.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机生成12个94-106之间的数字，保留三位小数点，并计算平均值
 */
public class RandomGenerate {

    public String[] getData(int num){
//        声明double类型数组，用于计算
        double data[] = new double[num];
//        生成String类型一维数组，用于返回保存在txt中
        String dataStr[] = new String[num];
//        12位数字的和
        double count = 0;
//        格式化日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        循环生成12位随机数并存入两个数组中
        for (int i = 1; i < num-1; i++) {
            double da = new Random().nextDouble()*12+94;
            BigDecimal bg = new BigDecimal(da);
            double f1 = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            data[i] = f1;
            count += f1;
//            将double类型数值转换为String数值保留三位小数，不足补0
            dataStr[i] = new DecimalFormat("#,##0.000").format(new Double(f1));
        }
        BigDecimal bg = new BigDecimal(count/12);
        double countaver = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
//        在记录的最后加上平均值
        dataStr[num-1] = Double.toString(countaver);
//        给每条记录加上日期
        dataStr[0] = sdf.format(new Date());
        return dataStr;
    }
}
