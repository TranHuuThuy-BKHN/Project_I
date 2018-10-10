package Operator;

import Chromosome.Chromosome;

import java.util.Random;

public class MutationSwap extends Mutation {

    @Override
    public void mutation(Chromosome child, Random r) {
        if (r.nextDouble() < Mutation.pM) {
            int p1 = 0, p2 = 0, temp = 0;
            do {
                p1 = r.nextInt(Chromosome.size);
                p2 = r.nextInt(Chromosome.size);
            } while (p1 == p2);
            System.out.println("MutationSwap : " + p1 + " <-> " + p2);
            temp = child.getValueChromosome()[p1];
            child.getValueChromosome()[p1] = child.getValueChromosome()[p2];
            child.getValueChromosome()[p2] = temp;

        }
    }
}
