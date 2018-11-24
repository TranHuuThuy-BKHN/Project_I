package Algorithm;

import Chromosome.Chromosome;
import Operator.CrossoverOder;
import Operator.MutationSwap;
import Operator.SelectionRank;
import Problem.TSP;

import javax.swing.*;
import java.util.Random;


public class Main {
    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            JOptionPane.showMessageDialog(null, "Chưa có tham số đầu vào", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fileName = args[0];
        double pC = Double.parseDouble(args[1]);
        double pM = Double.parseDouble(args[2]);
        int size = Integer.parseInt(args[3]);
        int loop = Integer.parseInt(args[4]);

        r.setSeed(1);
        TSP tsp = new TSP("Test/" + fileName);
        GeneticAlgorithm ga = new GeneticAlgorithm(tsp, pM, pC, size, TSP.coordinates.size(), r);

        Chromosome result = ga.run(loop, new CrossoverOder(), new MutationSwap(), new SelectionRank(), r);
        for (int i = 0; i < Chromosome.size; i++) {
            System.out.print(result.getValueChromosome()[i] + " ");
        }
        System.out.println("\nfitness :" + GeneticAlgorithm.problem.fitness(result));
    }
}

