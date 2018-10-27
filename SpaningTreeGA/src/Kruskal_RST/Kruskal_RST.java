package Kruskal_RST;

import java.util.Random;

/**
 * @author TranHuuThuy lớp chứa thuật toán sinh ngẫu nhiên cây khung (Spanning Tree)
 */
public class Kruskal_RST {

    /**
     * thuật toan sinh cây khung thứ nhất
     * @param e
     * @param v
     * @param r
     * @return
     */
    public static Edges getRST(Edges e, Vertices v, Random r) {
        Edges tree = new Edges();
        //Khởi tạo cha ban đầu của mỗi đỉnh
        for (int i = 0; i < v.getVertices().size(); i++) {
            DisjoinSets.market(v.getVertices().get(i));
        }

        int p1 = r.nextInt(e.getEdges().size()), p2 = r.nextInt(e.getEdges().size());
        Edge edge1 = e.getEdges().get(p1);
        Edge edge2 = e.getEdges().get(p2);

        e.getEdges().remove(p1);
        e.getEdges().add(p1, edge2);
        e.getEdges().remove(p2);
        e.getEdges().add(p2, edge1);

        for (int i = 0; i < e.getEdges().size(); i++) {
            if (DisjoinSets.find(e.getEdges().get(i).getU()).equals(DisjoinSets.find(e.getEdges().get(i).getV())) == false) {
                tree.addEdge(e.getEdges().get(i));
                DisjoinSets.unions(e.getEdges().get(i).getU(), e.getEdges().get(i).getV());
            }
        }
        return tree;
    }

    /**
     * thuật toán sinh cây khung thứ 2
     * @param e
     * @param v
     * @param r
     * @return
     */
    public static Edges getRST2(Edges e, Vertices v, Random r) {
        Edges tree = new Edges();
        Edges A = clone(e);
        //Khởi tạo cha ban đầu của mỗi đỉnh
        for (int i = 0; i < v.getVertices().size(); i++) {
            DisjoinSets.market(v.getVertices().get(i));
        }

        while (tree.getEdges().size() != v.getVertices().size() - 1) {
            Edge edge = A.getEdges().get(r.nextInt(A.getEdges().size()));
            if (DisjoinSets.find(edge.getU()).equals(DisjoinSets.find(edge.getV())) == false) {
                tree.addEdge(edge);
                DisjoinSets.unions(edge.getU(), edge.getV());
            }
            A.removeEdge(edge);
        }
        return tree;
    }

    private static Edges clone(Edges edges) {
        Edges temp = new Edges();
        for (Edge e : edges.getEdges()) {
            Edge e2 = new Edge(e.getU(), e.getV(), e.getWeight());
            temp.addEdge(e2);
        }
        return temp;
    }
}
