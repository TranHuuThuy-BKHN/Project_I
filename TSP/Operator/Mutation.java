package Operator;

import Chromosome.Chromosome;

import java.util.Random;

/**
 * @author TranHuuThuy
 * lớp chứa các phương thức đột biến
 */
public abstract class Mutation {

    public static double pM = 0.1; //xác suất đột biến

    /**
     * Phương thức đột biến cho một NST với xác suất pM
     * @param child
     * @param r
     */
    public abstract void mutation(Chromosome child, Random r);
}
