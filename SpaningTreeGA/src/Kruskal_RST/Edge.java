package Kruskal_RST;


/**
 * @author TranHuuThuy lớp cạnh của đồ thị chứa hai định và trọng số của nó
 */
public class Edge {
    private Vertex u, v;
    private double weight;
    private boolean check = false;

    public Edge() {

    }

    public Edge(Vertex u, Vertex v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Vertex getU() {
        return u;
    }

    public void setU(Vertex u) {
        this.u = u;
    }

    public Vertex getV() {
        return v;
    }

    public void setV(Vertex v) {
        this.v = v;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.u.getIndex() == ((Edge) obj).u.getIndex() && this.v.getIndex() == ((Edge) obj).v.getIndex())
                || (this.u.getIndex() == ((Edge) obj).v.getIndex() && this.v.getIndex() == ((Edge) obj).u.getIndex());
    }
}
