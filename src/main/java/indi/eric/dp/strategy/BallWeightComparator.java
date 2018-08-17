package indi.eric.dp.strategy;

/**
 * Created by qinsheng on 2018/8/18.
 */
public class BallWeightComparator implements Comparator {

    public int compare(Comparable c1, Comparable c2) {
        Ball b1 = (Ball)c1;
        Ball b2 = (Ball)c2;

        if(b1.getWeight() > b2.getWeight()) return 1;
        else if(b1.getWeight() < b2.getWeight()) return -1;
        else return 0;
    }
}
