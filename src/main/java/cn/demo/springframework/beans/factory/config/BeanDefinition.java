package cn.demo.springframework.beans.factory.config;

import cn.demo.springframework.beans.PropertyValues;

/**
 * @author BaiJY
 * @date 2023/06/16
 **/
public class BeanDefinition {


    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class bean) {
        this.beanClass = bean;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }


    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
