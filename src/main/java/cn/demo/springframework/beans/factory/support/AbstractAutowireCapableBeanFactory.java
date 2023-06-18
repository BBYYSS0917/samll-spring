package cn.demo.springframework.beans.factory.support;

import cn.demo.springframework.beans.BeansException;
import cn.demo.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new BeansException("Instantiation of bean failed", exception);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
