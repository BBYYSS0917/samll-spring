package cn.demo.springframework.beans.factory.config;

import cn.demo.springframework.beans.factory.BeanFactory;

/**
 * Extension of the {@link cn.demo.springframework.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 * @author BaiJY
 * @date 2023/06/21
 **/
public interface AutowireCapableBeanFactory extends BeanFactory {
}
