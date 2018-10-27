package View;

import Kruskal_RST.Vertex;
import javafx.scene.Parent;
import javafx.scene.paint.Color;


public class Line extends Parent {
    public Line(Vertex u, Vertex v) {
        javafx.scene.shape.Line l = new javafx.scene.shape.Line(u.getX() * 5, u.getY() * 5, v.getX() * 5, v.getY() * 5);
        l.setStroke(Color.RED);
        this.getChildren().add(l);
    }
}
