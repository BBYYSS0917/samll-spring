package cn.demo.springframework.beans.factory;

import cn.demo.springframework.beans.BeansException;

/**
 * @author BaiJY
 * @date 2023/06/16
 **/
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    Object getBean(String name,Object... args) throws BeansException;
}
