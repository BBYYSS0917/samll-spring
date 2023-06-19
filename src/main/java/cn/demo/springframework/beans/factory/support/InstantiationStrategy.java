package cn.demo.springframework.beans.factory.support;

import cn.demo.springframework.beans.BeansException;
import cn.demo.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
