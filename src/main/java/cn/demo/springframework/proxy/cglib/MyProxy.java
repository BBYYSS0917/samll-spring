package cn.demo.springframework.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class MyProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("这里可以插入执行关键代码之前的逻辑");
        Object o1 = methodProxy.invokeSuper(o, objects);//关键代码:
        System.out.println("这里可以插入执行关键代码之后的逻辑");
        return o1;
    }
}
