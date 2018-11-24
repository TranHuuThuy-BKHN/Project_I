package Problem;

import Chromosome.Chromosome;
import Chromosome.Population;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TSP extends Problem {

    public static ArrayList<Coordinate> coordinates = new ArrayList<>();

    public TSP(String fileName) {
        readData(fileName);
    }

    private void readData(String fileName) {
        try {
            Scanner sc = new Scanner(new FileInputStream(fileName));
            sc.nextLine();
            sc.nextLine();
            sc.nextLine();
            int d = Integer.parseInt(sc.nextLine().split(":")[1].substring(1)), i = 0;
            sc.nextLine();
            sc.nextLine();
            while (i++ < d) {
                Coordinate c = new Coordinate();
                sc.nextInt();
                c.x = sc.nextInt();
                c.y = sc.nextInt();
                coordinates.add(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * phương thức trả về tọa độ giữa hai đỉnh
     *
     * @param top1
     * @param top2
     * @return
     */
    private double distance(int top1, int top2) {
        double x = coordinates.get(top1 - 1).x - coordinates.get(top2 - 1).x;
        double y = coordinates.get(top1 - 1).y - coordinates.get(top2 - 1).y;
        return Math.sqrt(x * x + y * y);
    }

    /**
     * phương thức trả về fitness của một NST
     *
     * @param chromosome
     * @return
     */
    public double fitness(Chromosome chromosome) {
        double distance = 0.0;
        for (int i = 0; i < Chromosome.size - 1; i++) {
            distance += distance(chromosome.getValueChromosome()[i], chromosome.getValueChromosome()[i + 1]);
        }
        return distance + distance(chromosome.getValueChromosome()[Chromosome.size - 1], chromosome.getValueChromosome()[0]);
    }

    @Override
    public void initPopulation(Population population, Random r) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Chromosome.size; i++)
            list.add(i);

        int i = 0;
        while (i++ < Population.size) {
            int[] valueChromosome = new int[Chromosome.size];
            for (int j = 0; j < Chromosome.size; j++)
                valueChromosome[j] = list.get(j).intValue();

            population.addChromosome(new Chromosome(valueChromosome));
            Collections.shuffle(list, r);
        }
    }
}

