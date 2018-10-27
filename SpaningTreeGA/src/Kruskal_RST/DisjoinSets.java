package Kruskal_RST;

/**
 * @author TranHuuThuy  Cấu trúc disjoinSets được học
 * một cấu trúc disjoinSets gồm market, unions, find
 */
public class DisjoinSets {

    /**
     * phương thức đánh đấu ban đầu cho mỗi đỉnh, parent hiện tại chính là nó và có rank bằng 0
     *
     * @param v
     */
    public static void market(Vertex v) {
        v.setParent(v);
        v.setRank(0);
    }

    /**
     * phương thức tìm ra cha của đỉnh v đồng thời sửa chữa trên đưuòng đi để cho cây có chiều cao nhỏ
     *
     * @param v
     * @return
     */
    public static Vertex find(Vertex v) {
        if (v.getParent().equals(v) == false) {
            v.setParent(find(v.getParent()));
        }
        return v.getParent();
    }

    /**
     * phương thức kết nối hai đỉnh
     *
     * @param u
     * @param v
     */
    public static void unions(Vertex u, Vertex v) {
        Vertex parentU = find(u), parentV = find(v);
        if (parentU.equals(parentV)) return;
        else if (parentU.getRank() > parentV.getRank()) {
            parentV.setParent(u);
        } else {
            parentU.setParent(v);
            if (parentU.getRank() == parentV.getRank()) {
                parentV.setRank(parentV.getRank() + 1);
            }
        }
    }
}
