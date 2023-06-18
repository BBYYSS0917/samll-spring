package cn.demo.springframework.beans.factory.config;

/**
 * @author BaiJY
 * @date 2023/06/16
 **/
public class BeanDefinition {


    private Class beanClass;

    public BeanDefinition(Class bean) {
        this.beanClass = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
