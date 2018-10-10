package Chromosome;

/**
 * phương thức NST hay còn được gọi là một lời giải
 */
public class Chromosome {

    //mỗi nhiều sắc thể chứa các gen với số lượng nhất định, giả sử trong trường hợp này có 10 gen
    public static int size = 9;

    //một nhiễm sắc thể là một mảng n các gen
    private int[] valueChromosome = new int[size];

    public Chromosome() {
    }

    /**
     * mảng value pahir đame báo có n phần tử
     *
     * @param valueChromosome
     */
    public Chromosome(int[] valueChromosome) {
        System.arraycopy(valueChromosome, 0, this.valueChromosome, 0, size);
    }

    public int[] getValueChromosome() {
        return valueChromosome;
    }

    public void setValueChromosome(int[] valueChromosome) {
        System.arraycopy(valueChromosome, 0, this.valueChromosome, 0, size);
    }

    /**
     * phương thức kiểm tra xem hai nhiễm sắc thể có phải là như nhau hay không
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        for (int i = 0; i < size; i++) {
            if (valueChromosome[i] != ((Chromosome) obj).getValueChromosome()[i]) {
                return false;
            }
        }
        return true;
    }
}
