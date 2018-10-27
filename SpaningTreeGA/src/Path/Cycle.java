package Path;

import Kruskal_RST.Edge;
import Kruskal_RST.Edges;
import Kruskal_RST.Vertex;

import java.util.Stack;


/**
 * @author TranHuuThuy
 * lớp dùng để fix chu trình để tạo cây khung
 */
public class Cycle {

    private Edges tree;

    /**
     * hàm khởi tạo với tham số là một đồ thị có duy nhất 1 chu trình cần fix để tạo ra cây khung
     *
     * @param tree
     */
    public Cycle(Edges tree) {
        this.tree = tree;
    }

    /**
     * phương thức trả về chu trình hiện chỉ có trong đồ thị
     * @deprecated
     * @return
     */
    public Edges getCycle() {

        Edges temp = new Edges();
        for (int i = 0; i < tree.getEdges().size(); i++) {
            tree.getEdges().get(i).getU().setDeg(0);
            tree.getEdges().get(i).getV().setDeg(0);
            tree.getEdges().get(i).setCheck(true);
        }

        for (int i = 0; i < tree.getEdges().size(); i++) {
            tree.getEdges().get(i).getU().increaseDeg();
            tree.getEdges().get(i).getV().increaseDeg();
        }

        while (true) {
            boolean temp2 = false;

            for (int i = 0; i < tree.getEdges().size(); i++) {
                Edge e = tree.getEdges().get(i);
                if (e.isCheck()) {
                    if (e.getU().getDeg() == 1 || e.getV().getDeg() == 1) {
                        temp2 = true;
                        e.setCheck(false);
                        if (e.getU().getDeg() == 1) e.getV().reduceDeg();
                        if (e.getV().getDeg() == 1) e.getU().reduceDeg();
                    }
                }
            }

            if (temp2 == false) break;
        }

        for (int i = 0; i < tree.getEdges().size(); i++) {
            if (tree.getEdges().get(i).isCheck()) {
                tree.getEdges().get(i).setCheck(false);
                temp.addEdge(tree.getEdges().get(i));
            }
        }
        return temp;
    }

    /**
     * Phương thức trả về chu trình khi cho cạnh e vào cây khung
     * @param e
     * @return
     */
    public Edges getCycle(Edge e){
        Edges temp = new Edges();

       for(int i = 0; i < tree.getEdges().size(); i++){
           tree.getEdges().get(i).getU().getNeibor().clear();
           tree.getEdges().get(i).getV().getNeibor().clear();
       }

       for(int i = 0; i < tree.getEdges().size(); i++){
           tree.getEdges().get(i).getU().getNeibor().add(tree.getEdges().get(i).getV());
           tree.getEdges().get(i).getV().getNeibor().add(tree.getEdges().get(i).getU());
           tree.getEdges().get(i).getU().setCheck(false);
           tree.getEdges().get(i).getV().setCheck(false);
       }

       Stack<Vertex> stack = new Stack<>();
       stack.push(e.getU());

       boolean flag = false;
       while (stack.isEmpty() == false){
           Vertex s = stack.pop();
           s.setCheck(true);
           for(int i = 0; i < s.getNeibor().size(); i++){
              if(s.getNeibor().get(i).isCheck() == false){
                  s.getNeibor().get(i).setParent(s);
                  stack.push(s.getNeibor().get(i));
                  if(s.getNeibor().get(i).equals(e.getV())) {
                      flag = true;
                      break;
                  }
              }
           }
           if (flag) break;
       }
       Vertex t = e.getV();

       while (true){
           Edge edge = new Edge(t.getParent(), t, Vertex.distance(t, t.getParent()));
           System.out.print(t.getParent().getIndex() + ":" + t.getIndex() + " --> ");
           edge.setCheck(true);
           temp.addEdge(edge);
           t = t.getParent();
           if(t.equals(e.getU())) break;
       }
       return temp;
    }

}
