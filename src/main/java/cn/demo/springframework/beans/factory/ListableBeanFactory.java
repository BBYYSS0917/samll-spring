package cn.demo.springframework.beans.factory;

import cn.demo.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author BaiJY
 * @date 2023/06/21
 **/
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
