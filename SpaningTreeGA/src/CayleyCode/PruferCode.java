package CayleyCode;

import Kruskal_RST.Edge;
import Kruskal_RST.Edges;
import Kruskal_RST.Vertex;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author TranHuuThuy
 * lóp mã hóa một cây thành mã PruferCode
 */
public class PruferCode {

    private Edges tree = new Edges();

    public PruferCode(Edges tree) {
        for (Edge e : tree.getEdges()) {
            Edge edge = new Edge(e.getU().clone(), e.getV().clone(), 0);
            this.tree.addEdge(edge);
        }
    }

    public int[] get() {
        int res[] = new int[tree.getEdges().size()], k = 0;
        //khoi tao cac hang xom
        for (int i = 0; i < tree.getEdges().size(); i++) {
            tree.getEdges().get(i).getU().getNeibor().add(tree.getEdges().get(i).getV());
            tree.getEdges().get(i).getV().getNeibor().add(tree.getEdges().get(i).getU());
        }
        //Khởi tạo hàng đợi ưu tiên để theo chỉ số đỉnh nhỏ hơn
        PriorityQueue<Vertex> pQueue = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                if (o1.getIndex() < o2.getIndex()) return -1;
                else if (o1.getIndex() == o2.getIndex()) return 0;
                return 1;
            }
        });
        //cho tất cả đỉnh bậc 1 vào hàng đợi
        for (Edge e : tree.getEdges()) {
            if (e.getU().getNeibor().size() == 1 && e.getU().getIndex() != 0) pQueue.add(e.getU());
            if (e.getV().getNeibor().size() == 1 && e.getV().getIndex() != 0) pQueue.add(e.getV());
        }

        while (pQueue.isEmpty() == false) {
            Vertex v = pQueue.poll();
            res[k++] = v.getNeibor().get(0).getIndex();
            v.getNeibor().get(0).getNeibor().remove(v);
            if (v.getNeibor().get(0).getNeibor().size() == 1 && v.getNeibor().get(0).getIndex() != 0) {
                pQueue.offer(v.getNeibor().get(0));
            }
        }
        return res;
    }

}
