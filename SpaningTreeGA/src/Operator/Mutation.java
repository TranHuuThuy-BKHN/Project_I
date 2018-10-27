package Operator;

import Kruskal_RST.Edge;
import Kruskal_RST.Edges;
import Path.Cycle;

import java.util.Random;

public class Mutation {
    public static double pM = 2;

    /**
     * phương thức làm đột biến một cây khung
     *
     * @param child
     * @param edges
     * @param r
     */
    public void mutate(Edges child, Edges edges, Random r) {
        if (r.nextDouble() < Mutation.pM) {
            while (true) {
                Edge e = edges.getEdges().get(r.nextInt(edges.getEdges().size()));
                if (child.getEdges().contains(e) == false) {
                    //tìm chu trình và hủy bỏ một cạnh khác e
                    Edges cycle = new Cycle(clone(child)).getCycle(e);
                    //thêm cạnh đó vào
                    child.addEdge(e);
                    Edge temp = cycle.getEdges().get(r.nextInt(cycle.getEdges().size()));
                    System.out.print("Mutation :" + temp.getU().getIndex() + "-" + temp.getV().getIndex());
                    System.out.println(" --> " + e.getU().getIndex() + "-" + e.getV().getIndex());
                    child.removeEdge(temp);
                }
                break;
            }
        }
    }

    private Edges clone(Edges parent) {
        Edges temp = new Edges();
        for (Edge e : parent.getEdges()) {
            Edge edge = new Edge(e.getU(), e.getV(), e.getWeight());
            temp.getEdges().add(edge);
        }
        return temp;
    }
}
