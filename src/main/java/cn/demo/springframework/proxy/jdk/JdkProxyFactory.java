package cn.demo.springframework.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}
