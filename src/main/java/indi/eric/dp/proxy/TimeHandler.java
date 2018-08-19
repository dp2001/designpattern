package indi.eric.dp.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by qinsheng on 2018/8/20.
 */
public class TimeHandler implements InvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public TimeHandler(Object target) {
        this.target = target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void invoke(Object o, Method method) {
        long start = System.currentTimeMillis();
        System.out.println("Start time: " + start);
        try {
            method.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("End time: " + end);
        System.out.println("Time : " + (end - start));
    }

}
