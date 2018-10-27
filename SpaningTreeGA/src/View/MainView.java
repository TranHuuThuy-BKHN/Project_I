package View;

import Kruskal_RST.*;
import Operator.Crossover;
import Operator.Mutation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class MainView extends Application {
    private Paint p[] = new Paint[6];
    Random r = new Random(1);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Vertices vertices = new Vertices();
        Edges edges = new Edges();
        Scanner sc = new Scanner(new File("points"));
        while (sc.hasNext()) {
            Vertex v = new Vertex(sc.nextInt(), sc.nextInt(), sc.nextInt());
            vertices.addVertex(v);
        }

        Scanner sc2 = new Scanner((new File("edges.txt")));
        while (sc2.hasNext()) {
            Edge e = new Edge();
            e.setU(vertices.getVertices().get(sc2.nextInt()));
            e.setV(vertices.getVertices().get(sc2.nextInt()));
            edges.addEdge(e);
        }

        p[0] = new Paint();
        p[1] = new Paint();
        p[2] = new Paint();
        p[3] = new Paint();
        p[4] = new Paint();
        p[5] = new Paint();

        Edges tree1 = Kruskal_RST.getRST2(edges, vertices, r);
        Edges tree2 = Kruskal_RST.getRST2(edges, vertices, r);


        Edges childrent[] = new Crossover().cross(tree1, tree2, r);

        p[0].drawGraph(edges, vertices);
        p[1].drawGraph(tree1, vertices);
        p[2].drawGraph(tree2, vertices);

        new Mutation().mutate(tree1, edges, r);
        p[5].drawGraph(tree1, vertices);

        Scene s = new Scene(p[0], 250, 250);
        Scene s2 = new Scene(p[1], 250, 250);
        Scene s3 = new Scene(p[2], 250, 250);

        Stage pr = new Stage();
        pr.setTitle("RST 1");
        pr.setScene(s2);

        Stage pr2 = new Stage();
        pr2.setTitle("RST 2");
        pr2.setScene(s3);

        Stage pr6 = new Stage();
        pr6.setTitle("Mutation RST 1");
        pr6.setScene(new Scene(p[5], 250, 250));
        pr6.show();

        primaryStage.setTitle("G");
        primaryStage.setScene(s);

        primaryStage.show();
        pr.show();
        pr2.show();

        if (childrent != null) {
            p[3].drawGraph(childrent[0], vertices);
            p[4].drawGraph(childrent[1], vertices);
            Scene s4 = new Scene(p[3], 250, 250);
            Scene s5 = new Scene(p[4], 250, 250);

            Stage pr4 = new Stage();
            pr4.setTitle("Child 1");
            pr4.setScene(s4);
            pr4.show();

            Stage pr5 = new Stage();
            pr5.setTitle("Child 2");
            pr5.setScene(s5);
            pr5.show();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
