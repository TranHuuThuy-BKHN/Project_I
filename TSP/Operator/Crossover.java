package Operator;

import Chromosome.Chromosome;

import java.util.Random;

/**
 * @author TranHuuThuy
 * lớp chứa các phương thức lai tạo
 */
public abstract class Crossover {

    public static double pC = 0.7; //xác suất lai tạo

    /**
     * phương thức lai tạo với xác suất pM
     * @param parent1
     * @param parent2
     * @param r
     * @return
     */
    public abstract Chromosome[] crossover(Chromosome parent1, Chromosome parent2, Random r);

}
