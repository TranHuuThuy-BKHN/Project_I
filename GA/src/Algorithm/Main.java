package Algorithm;

import Chromosome.Chromosome;
import Operator.CrossoverOder;
import Operator.MutationSwap;
import Operator.SelectionRank;
import Problem.TSP;

import java.util.Random;


public class Main {
    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        r.setSeed(1);
        TSP tsp = new TSP("dataTSP2.txt");
        GeneticAlgorithm ga = new GeneticAlgorithm(tsp, 0.05, 0.8, 100, TSP.coordinates.size(), r);
        while (true) {
            Chromosome result = ga.run(100, new CrossoverOder(), new MutationSwap(), new SelectionRank(), r);
            for (int i = 0; i < Chromosome.size; i++) {
                System.out.print(result.getValueChromosome()[i] + " ");
            }
            System.out.println("\nfitness :" + GeneticAlgorithm.problem.fitness(result));
            Thread.sleep(1000);
        }
    }
}

