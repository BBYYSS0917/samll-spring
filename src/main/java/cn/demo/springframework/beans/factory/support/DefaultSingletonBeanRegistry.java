package cn.demo.springframework.beans.factory.support;

import cn.demo.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.*;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    //继承了该类的其他类能调用该add方法
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
