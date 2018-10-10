package Operator;

import Chromosome.Population;

/**
 * @author TranHuuThuy
 * lớp chọn lọc
 */
public abstract class Selection {
    public abstract void select(Population p, Population childs);
}
