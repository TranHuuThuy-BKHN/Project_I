package Kruskal_RST;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.Math.sqrt;

/**
 * @author TranHuuThuy lớp đỉnh của đồ thị
 */
public class Vertex implements Cloneable{
    private int index, rank, deg;
    private Vertex parent;

    //danh sach các hàng xóm
    private LinkedList<Vertex> neibor = new LinkedList<>();
    private boolean check = false;
    private int x, y;

    public Vertex() {

    }

    public Vertex(int index) {
        this.index = index;
    }

    public Vertex(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public LinkedList<Vertex> getNeibor() {
        return neibor;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public void increaseDeg() {
        this.deg++;
    }

    public void reduceDeg() {
        this.deg--;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        return this.index == ((Vertex) obj).index;
    }

    public static double distance(Vertex u, Vertex v) {
        return sqrt((u.getX() - v.getX()) * (u.getX() - v.getX()) + (u.getY() - v.getY()) * (u.getY() - v.getY()));
    }

    public Vertex clone(){
        try {
            return (Vertex)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this;
        }
    }
}
