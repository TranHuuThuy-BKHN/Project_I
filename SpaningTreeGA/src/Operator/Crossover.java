package Operator;

import Kruskal_RST.Edge;
import Kruskal_RST.Edges;
import Path.Cycle;

import java.util.Random;

public class Crossover {
    public static double pC = 2;

    /**
     * phương thức lai tạo sinh ra một con từ parent1
     *
     * @param parent1
     * @param parent2
     * @param r
     * @return
     */
    private Edges cross1(Edges parent1, Edges parent2, Random r) {
        Edges e = new Edges();
        //tìm tập có trong parent1 mà không có trong parent2
        for (Edge edge : parent1.getEdges()) {
            if (parent2.getEdges().contains(edge) == false)
                e.addEdge(edge);
        }

        if (e.getEdges().size() == 0) return null;
        else {
            //xác định tập cho vào parent2
            int k = r.nextInt(e.getEdges().size()), i = 0, j = 0;
            System.out.println("Số lượng cho xóa k = " + k);

            while (i++ < k) {
                j = r.nextInt(e.getEdges().size());
                e.getEdges().remove(j);
            }

            //đánh dấu là cá thể bỏ
            for (i = 0; i < parent2.getEdges().size(); i++)
                parent2.getEdges().get(i).setCheck(true);

            //bắt đầu quá trình thêm, với mỗi lần thêm, ta cần loại bỏ chu trình
            for (i = 0; i < e.getEdges().size(); i++) {
                System.out.println(e.getEdges().get(i).getU().getIndex() + " " + e.getEdges().get(i).getV().getIndex());
                //tìm ra chu trình khi thêm
                Edges cycle = new Cycle(parent2).getCycle(e.getEdges().get(i));
                parent2.getEdges().add(e.getEdges().get(i));
                System.out.println("Cycle :" + cycle.getEdges().size());

                //đánh dấu lại tất cả các cạnh vừa mới thêm để ko đc bỏ trong các lần tiếp
                for (j = 0; j <= i; j++) {
                    e.getEdges().get(j).setCheck(false);
                }

                Edge edge = cycle.getEdges().get(r.nextInt(cycle.getEdges().size()));
                System.out.println("Bỏ " + edge.getU().getIndex() + ":" + edge.getV().getIndex());
                parent2.removeEdge(edge);
            }
        }
        return parent2;
    }


    /**
     * phương thức lai tạo ra hai cây khung con từ cha mẹ
     *
     * @param parent1
     * @param parent2
     * @param r
     * @return
     */
    public Edges[] cross(Edges parent1, Edges parent2, Random r) {

        if (r.nextDouble() < Crossover.pC) {
            Edges children[] = new Edges[2];
            children[0] = cross1(clone(parent1), clone(parent2), r);
            children[1] = cross1(clone(parent2), clone(parent1), r);
            return children;
        }

        return null;
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
