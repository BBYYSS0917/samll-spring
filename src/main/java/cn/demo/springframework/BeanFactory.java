package cn.demo.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author BaiJY
 * @date 2023/06/16
 **/
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
