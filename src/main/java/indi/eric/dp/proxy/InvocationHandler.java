package indi.eric.dp.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by qinsheng on 2018/8/20.
 */
public interface InvocationHandler {
    void invoke(Object o, Method method) throws InvocationTargetException, IllegalAccessException;
}
