package cn.demo.springframework;

/**
 * @author BaiJY
 * @date 2023/06/16
 **/
public class BeanDefinition {


    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
