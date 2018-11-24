package Operator;

import Algorithm.GeneticAlgorithm;
import Chromosome.Chromosome;
import Chromosome.Population;
import Problem.Problem;

import java.util.Collections;
import java.util.Comparator;

public class SelectionRank extends Selection {

    @Override
    public void select(Population p, Population child) {
        Problem problem = GeneticAlgorithm.problem;
        //giữ lại cái tốt nhất
        Chromosome maxChromosome = Collections.min(p.getValuePopulation(), new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                double f1 = problem.fitness(o1);
                double f2 = problem.fitness(o2);
                if (f1 > f2) return 1;
                else if (f1 < f2) return -1;
                else return 0;
            }
        });

        for (int i = 0; i < Population.size; i++) {
            if (problem.fitness(maxChromosome) < problem.fitness(child.getValuePopulation().get(i))) {
                child.getValuePopulation().remove(i);
                child.addChromosome(maxChromosome);
                break;
            }
        }
        p.setValuePopulation(child.getValuePopulation());
    }
}
