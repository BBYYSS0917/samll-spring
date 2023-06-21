package cn.demo.springframework.beans.factory.support;

import cn.demo.springframework.core.io.DefaultResourceLoader;
import cn.demo.springframework.core.io.ResourceLoader;

/**
 * @author BaiJY
 * @date 2023/06/20
 **/
public abstract class AbstractBeanDefinitonReader implements BeanDefinitonReader {

    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitonReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitonReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
