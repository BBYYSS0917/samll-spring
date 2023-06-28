package cn.demo.springframework.beans.factory;

import cn.demo.springframework.beans.BeansException;
import cn.demo.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.demo.springframework.beans.factory.config.BeanDefinition;
import cn.demo.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * @author BaiJY
 * @date 2023/06/21
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
