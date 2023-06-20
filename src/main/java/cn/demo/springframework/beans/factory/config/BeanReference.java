package cn.demo.springframework.beans.factory.config;

/**
 * Bean的引用
 * @author BaiJY
 * @date 2023/06/20
 **/
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
