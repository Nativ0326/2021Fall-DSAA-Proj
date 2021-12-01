package nBody;

public class Quad {
    private double xmid;
    private double ymid;
    private double length;

    public Quad(double _xmid, double _ymid, double _length){
        xmid = _xmid;
        ymid = _ymid;
        length = _length;
    }

    public boolean contains(double x, double y){
        // 判断给定(x,y)是否在该平面中
        double x_l = xmid - length / 2;
        double x_r = xmid + length / 2;
        double y_l = ymid - length / 2;
        double y_r = ymid + length / 2;
        // [x_l, x_r] 表示该平面的左右区域限制
        // [y_l, y_r] 表示该平面的上下区域限制
        if(x_l <= x && x <= x_r && y_l <= y && y <= y_r)
            return true;
        else return false;
    }

    public double get_length(){
        return length;
    }

    public double get_xmid(){
        return xmid;
    }

    public double get_ymid(){
        return ymid;
    }

    public Quad NW(){ // 该象限标号为1
        double nxt_length = length / 4;
        double xmid1 = xmid - nxt_length / 2;
        double ymid1 = ymid + nxt_length / 2;
        return new Quad(nxt_length, xmid1, ymid1);
    }

    public Quad NE(){ // 该象限标号为2
        double nxt_length = length / 4;
        double xmid2 = xmid + nxt_length / 2;
        double ymid2 = ymid + nxt_length / 2;
        return new Quad(nxt_length, xmid2, ymid2);
    }

    public Quad SW(){ // 该象限标号为3
        double nxt_length = length / 4;
        double xmid3 = xmid - nxt_length / 2;
        double ymid3 = ymid - nxt_length / 2;
        return new Quad(nxt_length, xmid3, ymid3);
    }

    public Quad SE(){ // 该象限的标号为4
        double nxt_length = length / 4;
        double xmid4 = xmid + nxt_length / 2;
        double ymid4 = ymid - nxt_length / 2;
        return new Quad(nxt_length, xmid4, ymid4);
    }

    public String toString(){
        String output = "[" + xmid + ", " + ymid + "] length = " + length + "\n";
        return output;
    }

    public void draw(){
        // 我没有搞懂这个是要做什么qwqwqwqwqwqwq
        // 有空了再写
    }

}
