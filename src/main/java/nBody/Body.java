package nBody;

import java.util.ArrayList;

public class Body {
    private int id; // 索引下标
    private double mass; // mass 代表的是这一团的等效重量
    private double rx;
    private double ry; // 中心也是这一团点的等效中心
    private boolean is_internal; // 判断是internal还是external nodes
    private ArrayList contain_nodes = new ArrayList(); // 如果是internal nodes,表示他所代表的一系列点

    public Body(int _id, double _mass, double _rx, double _ry, boolean _is_internal){
        id = _id;
        mass = _mass;
        rx = _rx;
        ry = _ry;
        is_internal = _is_internal;
    }

    public boolean in(Quad q){ // 判断这个/团点是否在这个q面上
        return q.contains(rx, ry);
    }

//    public Body plus(){ //
//
//    }
}
