package cn.demo.springframework.beans.factory.support;

import cn.demo.springframework.beans.BeansException;
import cn.demo.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != constructor) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
