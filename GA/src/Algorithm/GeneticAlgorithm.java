package Algorithm;

import Chromosome.*;
import Operator.Crossover;
import Operator.Mutation;
import Operator.Selection;
import Problem.Problem;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


public class GeneticAlgorithm {

    public static Problem problem;

    private Population population = new Population();

    public GeneticAlgorithm(Problem problem, double pM, double pC, int sizePopulation, int sizeChoromosome, Random r) {
        this.problem = problem;
        Crossover.pC = pC;
        Mutation.pM = pM;
        Population.size = sizePopulation;
        Chromosome.size = sizeChoromosome;
        problem.initPopulation(population, r);
    }

    private void tournamentCrossover(Crossover cro, Population childs, Random r) {
        while (childs.getValuePopulation().size() != Population.size) {

            Chromosome a = population.getValuePopulation().get(r.nextInt(Population.size));
            Chromosome b = population.getValuePopulation().get(r.nextInt(Population.size));
            Chromosome c = population.getValuePopulation().get(r.nextInt(Population.size));
            Chromosome d = population.getValuePopulation().get(r.nextInt(Population.size));

            Chromosome parent1, parent2;
            if (problem.fitness(a) > problem.fitness(b)) parent1 = b;
            else parent1 = a;

            if (problem.fitness(c) > problem.fitness(d)) parent2 = d;
            else parent2 = c;

            if (parent1.equals(parent2) == false) {
                Chromosome child[] = cro.crossover(parent1, parent2, r);
                if (child != null) {
                    childs.addChromosome(child[0]);
                    childs.addChromosome(child[1]);
                }
            }

        }
    }

    public Chromosome run(int loop, Crossover cro, Mutation mut, Selection sel, Random r) {
        int i = 0;
        while (i++ < loop) {
            Population childs = new Population();
            //Lai ghép
            tournamentCrossover(cro, childs, r);
            //đột biến
            for (int j = 0; j < Population.size; j++)
                mut.mutation(childs.getValuePopulation().get(j), r);
            sel.select(population, childs);
        }

        Chromosome maxChromosome = Collections.min(population.getValuePopulation(), new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                double f1 = problem.fitness(o1);
                double f2 = problem.fitness(o2);
                if (f1 > f2) return 1;
                else if (f1 < f2) return -1;
                else return 0;
            }
        });
        return  maxChromosome;
    }
}
