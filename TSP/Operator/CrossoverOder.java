package Operator;

import Chromosome.Chromosome;

import java.util.Random;

public class CrossoverOder extends Crossover {

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
            child[0] = crossoverOrder1(parent1, parent2, head, tail);
            child[1] = crossoverOrder1(parent2, parent1, head, tail);
            return child;
        }
        return null;
    }

    private Chromosome crossoverOrder1(Chromosome parent1, Chromosome parent2, int head, int tail) {
        int[] valueChoromosome = new int[Chromosome.size];
        int j = tail + 1, i = tail + 1;
        System.arraycopy(parent1.getValueChromosome(), head, valueChoromosome, head, tail - head + 1);

        do {
            if (i == Chromosome.size) i = 0;
            if (j == Chromosome.size) j = 0;
            if (search(valueChoromosome, parent2.getValueChromosome()[j]) == false) {
                valueChoromosome[i++] = parent2.getValueChromosome()[j];
            }
            j++;
        } while (j != tail + 1);

        return new Chromosome(valueChoromosome);
    }

    private boolean search(int[] array, int value) {
        for (int val : array) {
            if (val == value) return true;
        }
        return false;
    }
}
