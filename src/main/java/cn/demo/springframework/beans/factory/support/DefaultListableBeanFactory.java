package cn.demo.springframework.beans.factory.support;

import cn.demo.springframework.beans.BeansException;
import cn.demo.springframework.beans.factory.config.BeanDefinition;

import java.util.*;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();


    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefiniton(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

//    public <T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException {
//        Map<String, T> result = new HashMap<>();
//        beanDefinitionMap.forEach((bean));
//    }
//

    @Override
    public String[] getBeanDefinitonNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }
}

