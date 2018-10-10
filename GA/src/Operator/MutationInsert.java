package Operator;

import Chromosome.Chromosome;

import java.util.Random;

public class MutationInsert extends Mutation{
    @Override
    public void mutation(Chromosome child, Random r) {
        if (r.nextDouble() < Mutation.pM) {
            int p1 = 0, p2 = 0, temp = 0;
            do {
                p1 = r.nextInt(Chromosome.size);
                p2 = r.nextInt(Chromosome.size);
                if (p2 < p1) {
                    temp = p1;
                    p1 = p2;
                    p2 = temp;
                }
            } while (p2 - p1 < 2);

            System.out.println("MutationInsert : " + p1 + " -> " + p2);
            int temp2[] = new int[p2 - p1 - 1];
            System.arraycopy(child.getValueChromosome(), p1 + 1, temp2, 0, temp2.length);
            child.getValueChromosome()[p1 + 1] = child.getValueChromosome()[p2];
            System.arraycopy(temp2, 0, child.getValueChromosome(), p1 + 2, temp2.length);

        }
    }
}
