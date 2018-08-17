package indi.eric.dp.strategy;

/**
 * Created by qinsheng on 2018/8/18.
 */
public class PersonAgeComparator implements Comparator {

    public int compare(Comparable c1, Comparable c2) {
        Person b1 = (Person)c1;
        Person b2 = (Person)c2;

        if(b1.getAge() > b2.getAge()) return 1;
        else if(b1.getAge() < b2.getAge()) return -1;
        else return 0;
    }
}
