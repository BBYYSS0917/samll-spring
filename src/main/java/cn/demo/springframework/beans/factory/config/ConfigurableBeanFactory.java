package cn.demo.springframework.beans.factory.config;

import cn.demo.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author BaiJY
 * @date 2023/06/21
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
