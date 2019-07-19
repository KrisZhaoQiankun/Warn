package fun.krisme.entity;

/**
 * 从txt文本读取的数据对象
 */
public class Result {

    private String data; //从txt文本中读取的字符串
    private int length; //返回的txt的长度
    private int row; //返回的txt的行数

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
