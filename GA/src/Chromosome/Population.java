package Chromosome;

import Chromosome.Chromosome;

import java.util.LinkedList;

/**
 * @author TranHuuThuy
 * lớp quần thể, chứa một số lượng NST
 */
public class Population {

    //số lượng nhiếm sác thể cần có trong quần thể
    public static int size = 10;

    //các nhiễm sắc thể được lưu trong cấu trúc LinkedList, phù hợp cho việc thay đổi quần thể
    private LinkedList<Chromosome> valuePopulation = new LinkedList<>();

    public LinkedList<Chromosome> getValuePopulation() {
        return valuePopulation;
    }

    public void setValuePopulation(LinkedList<Chromosome> valuePopulation) {
        this.valuePopulation = valuePopulation;
    }

    /**
     * phương thức thêm cuối quần thể một nhiễm sắc thể
     *
     * @param chromosome
     */
    public void addChromosome(Chromosome chromosome) {
        valuePopulation.add(chromosome);
    }

    /**
     * phương thức xóa một nhiễm sắc thể ở vị trí index trong quần thể hiện tại
     *
     * @param index
     */
    public void removeaddChromosome(int index) {
        valuePopulation.remove(index);
    }
}
