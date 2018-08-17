package indi.eric.dp.strategy;

/**
 * Created by qinsheng on 2018/8/18.
 */
public class Person implements Comparable{
    private Comparator comparator = new PersonHeightComparator();

    private int age;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int height;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Person(int age, String name, int height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Comparable o) {
        return comparator.compare(this, o);
    }
}
