package indi.eric.dp.proxy;

import java.util.Random;

/**
 * Created by qinsheng on 2018/8/19.
 */
public class Tank implements Moveable {

    public void move() {
        System.out.println("Tank is moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
