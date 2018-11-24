package Operator;

import Chromosome.Chromosome;

import java.util.Random;

public class CrossoverPMX extends Crossover {
    @Override
    public Chromosome[] crossover(Chromosome parent1, Chromosome parent2, Random r) {
        if (r.nextDouble() < Crossover.pC) {
            int head = r.nextInt(Chromosome.size);
            int tail = r.nextInt(Chromosome.size);
            if (head > tail) {
                int temp = head;
                head = tail;
                tail = temp;
            }
            Chromosome child[] = new Chromosome[2];
            child[0] = crossoverPMX1(parent1, parent2, head, tail);
            child[1] = crossoverPMX1(parent2, parent1, head, tail);
            return child;
        }
        return null;
    }

    private Chromosome crossoverPMX1(Chromosome parent1, Chromosome parent2, int head, int tail) {
        Chromosome parent = new Chromosome(parent2.getValueChromosome());
        for (int i = head; i <= tail; i++) {
            if (parent1.getValueChromosome()[i] != parent.getValueChromosome()[i]) {
                //ta thực hiện việc đổi chỗ
                for (int j = 0; j < Chromosome.size; j++) {
                    if (parent1.getValueChromosome()[i] == parent.getValueChromosome()[j]) {
                        int temp = parent.getValueChromosome()[i];
                        parent.getValueChromosome()[i] = parent.getValueChromosome()[j];
                        parent.getValueChromosome()[j] = temp;
                        break;
                    }
                }
            }
        }
        //lúc này parent2 sẽ là kết quả
        return parent;
    }

}
