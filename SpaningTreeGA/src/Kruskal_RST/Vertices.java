package Kruskal_RST;


import java.util.ArrayList;

/**
 * @author TranHuuThuy lớp chứa các đỉnh của đồ thị G
 */
public class Vertices {
    private ArrayList<Vertex> vertices = new ArrayList<>();

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    /**
     * phương thức thêm một định vào đồ thị
     *
     * @param v
     */
    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    /**
     * phương thức thêm nhiều đỉnh vào đồ thị
     *
     * @param vertices
     */
    public void addAllVertices(Vertex... vertices) {
        for (Vertex v : vertices) {
            addVertex(v);
        }
    }

    /**
     * phuonwg thức xóa một đỉnh khỏi đồ thị
     *
     * @param v
     */
    public void remove(Vertex v) {
        vertices.remove(v);
    }
}
