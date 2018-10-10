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
            System.out.println("CrossoverOder : " + head + " -> : " + tail);
            child[0] = crossoverOrder1(parent1, parent2, head, tail);
            child[1] = crossoverOrder1(parent2, parent1, head, tail);
            return child;
        }
        return null;
    }

    private Chromosome crossoverOrder1(Chromosome parent1, Chromosome parent2, int head, int tail) {
        int[] valueChoromosome = new int[Chromosome.size];
        int j = 0, i = 0;
        System.arraycopy(parent1.getValueChromosome(), head, valueChoromosome, head, tail - head + 1);
        //Mảng chứa các phần tử chưa xuất hiện ở valueChoromosome trong parent2
        int temp2[] = new int[Chromosome.size - tail + head - 1];

        for (int value : parent2.getValueChromosome()) {
            if (search(valueChoromosome, value) == false) {
                temp2[i++] = value;
            }
        }

        for (int value : temp2) {
            if (j == Chromosome.size) j = 0;
            if (j == head) j = tail + 1;
            valueChoromosome[j++] = value;
        }

        return new Chromosome(valueChoromosome);
    }

    private boolean search(int[] array, int value) {
        for (int val : array) {
            if (val == value) return true;
        }
        return false;
    }
}
