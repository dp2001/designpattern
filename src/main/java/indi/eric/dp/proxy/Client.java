package indi.eric.dp.proxy;

/**
 * Created by qinsheng on 2018/8/19.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Tank t = new Tank();
        InvocationHandler th = new TimeHandler(t);

        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, th);

        m.move();
    }

}
