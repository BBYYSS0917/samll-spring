package cn.demo.springframework.beans.factory;

import cn.demo.springframework.beans.BeansException;
import cn.demo.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.demo.springframework.core.io.Resource;
import cn.demo.springframework.core.io.ResourceLoader;

/**
 * @author BaiJY
 * @date 2023/06/20
 **/
public interface BeanDefinitonReader {
    //这里需要注意 getRegistry()、getResourceLoader()，都是用于提供给后面三个方法的工具，加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法。
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitons(Resource resource) throws BeansException;

    void loadBeanDefinitons(Resource... resources) throws BeansException;

    void loadBeanDefinitons(String location) throws BeansException;
}
