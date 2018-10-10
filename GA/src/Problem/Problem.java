package Problem;

import Chromosome.*;

import java.util.Random;

public abstract class Problem {

    //hàm tính độ thích nghi
    public abstract double fitness(Chromosome chromosome);

    //phương thức khởi tạo quần thể có kích thước đã được xác định
    public abstract void initPopulation(Population population, Random r);
}
