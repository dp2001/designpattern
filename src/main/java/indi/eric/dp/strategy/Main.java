package indi.eric.dp.strategy;

/**
 * Created by qinsheng on 2018/8/17.
 */
public class Main {

    public static void main(String[] args) {

        Person person[] = {new Person(1,"james", 203),
                new Person(15, "kobe", 196),
                new Person(9, "love", 208)};

        Ball ball[] = {
                new Ball(1), new Ball(100), new Ball(80)
        };

        DataSorter dataSorter = new DataSorter();
        dataSorter.sort(person);
        dataSorter.print(person);

    }

}
