package indi.eric.dp.strategy;

/**
 * Created by qinsheng on 2018/8/18.
 */
public class Ball implements Comparable{
    private Comparator comparator= new BallWeightComparator();

    private int weight;

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "weight=" + weight +
                '}';
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Ball(int weight) {
        this.weight = weight;
    }

    public int compareTo(Comparable comparable) {
        return comparator.compare(this, comparable);
    }
}
