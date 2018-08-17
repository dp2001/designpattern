package indi.eric.dp.strategy;

/**
 * Created by qinsheng on 2018/8/18.
 */
public class PersonHeightComparator implements Comparator {

    public int compare(Comparable c1, Comparable c2) {
        Person p1 = (Person)c1;
        Person p2 = (Person)c2;

        if(p1.getHeight() > p2.getHeight()) return 1;
        else if(p1.getHeight() < p2.getHeight()) return -1;
        else return 0;
    }
}
