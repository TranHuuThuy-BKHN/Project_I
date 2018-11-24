package Operator;

import Chromosome.Chromosome;

import java.util.Random;

public class MutationInversion extends Mutation {
    @Override
    public void mutation(Chromosome child, Random r) {
        if(r.nextDouble() < Mutation.pM){
            int p1 = 0, p2 = 0, temp = 0, length = 0;
            do {
                p1 = r.nextInt(Chromosome.size);
                p2 = r.nextInt(Chromosome.size);
            } while (p1 == p2);

            if (p1 > p2) {
                temp = p1;
                p1 = p2;
                p2 = temp;
            }
            length = p2 - p1 + 1;
            for (int i = 0; i < length / 2; i++) {
                temp = child.getValueChromosome()[i + p1];
                child.getValueChromosome()[i + p1] = child.getValueChromosome()[p2 - i];
                child.getValueChromosome()[p2 - i] = temp;
            }
        }
    }
}
