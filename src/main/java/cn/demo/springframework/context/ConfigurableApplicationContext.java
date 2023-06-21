package cn.demo.springframework.context;

import cn.demo.springframework.beans.BeansException;

/**
 * @author BaiJY
 * @date 2023/06/21
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
