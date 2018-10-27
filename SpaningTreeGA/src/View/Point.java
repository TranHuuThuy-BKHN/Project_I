package View;


import Kruskal_RST.Vertex;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Point extends Parent {
    public Point(Vertex v){
        Circle c = new Circle(v.getX() * 5, v.getY() * 5, 5);
        c.setFill(Color.RED);
        Label l = new Label(v.getIndex() + "");
        l.setTextFill(Color.BLUE);
        l.setLayoutX(v.getX() * 5 + 5);
        l.setLayoutY(v.getY() * 5 - 5);

        this.getChildren().addAll(c, l);
    }
}
