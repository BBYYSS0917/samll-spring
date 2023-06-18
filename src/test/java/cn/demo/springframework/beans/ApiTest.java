package cn.demo.springframework.beans;

import cn.demo.springframework.beans.bean.UserService;
import cn.demo.springframework.beans.factory.BeanFactory;
import cn.demo.springframework.beans.factory.config.BeanDefinition;
import cn.demo.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author BaiJY
 * @date 2023/06/16
 **/
public class ApiTest {



    @Test
    public void test_BeanFactory() {
//        BeanFactory beanFactory = new BeanFactory();
//
//        UserService userService = new UserService();
//        beanFactory.registerBeanDefinition("userservice",new BeanDefinition(userService));
//
//        UserService userService1=(UserService) beanFactory.getBean("userservice");
//        userService1.queryUserInfo();

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();
    }


}
