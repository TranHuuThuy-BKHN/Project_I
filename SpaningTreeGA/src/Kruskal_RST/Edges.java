package Kruskal_RST;


import java.util.LinkedList;

/**
 * @author TranHuuThuy lớp chứa tập hợp cạnh của đồ thị G
 */
public class Edges {
    private LinkedList<Edge> edges = new LinkedList<>();

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Phương thức thêm một cạnh vào đồ thị
     *
     * @param e
     */
    public void addEdge(Edge e) {
        edges.add(e);
    }

    /**
     * phương thức thêm nhiều cạnh vào đồ thị
     *
     * @param edges
     */
    public void addAllEdges(Edge... edges) {
        for (Edge e : edges) {
            addEdge(e);
        }
    }

    /**
     * phương thức xóa một cạnh khỏi tập cạnh
     *
     * @param e
     */
    public void removeEdge(Edge e) {
        edges.remove(e);
    }

}
