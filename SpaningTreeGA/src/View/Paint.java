package View;

import Kruskal_RST.Edge;
import Kruskal_RST.Edges;
import Kruskal_RST.Vertex;
import Kruskal_RST.Vertices;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Paint extends Pane {

    public Paint() {

    }

    public Paint(ArrayList<Vertex> vertices) {
        for (Vertex v : vertices) {
            this.getChildren().add(new Point(v));
        }
    }

    public void draw(Vertex u, Vertex v) {
        Line l = new Line(u, v);
        this.getChildren().addAll(l);
    }

    public void drawGraph(Edges edges, Vertices vertices) {
        this.getChildren().clear();
        for (Vertex v : vertices.getVertices()) {
            this.getChildren().add(new Point(v));
        }
        for (Edge e : edges.getEdges()) {
            this.draw(e.getU(), e.getV());
        }
    }

}
