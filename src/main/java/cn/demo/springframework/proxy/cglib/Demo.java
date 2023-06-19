package cn.demo.springframework.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class Demo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();  // 通过CGLIB动态代理获取代理对象的过程
        enhancer.setSuperclass(User.class);     // 设置enhancer对象的父类
        enhancer.setCallback(new MyProxy());    // 设置enhancer的回调对象
        User user = (User) enhancer.create();   // 创建代理对象
        String world = user.say("world");  // 通过代理对象调用目标方法
    }
}
