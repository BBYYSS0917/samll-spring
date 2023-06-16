package cn.demo.springframework.test;

import cn.demo.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author BaiJY
 * @date 2023/06/16
 **/
public class ApiTest {



    @Test
    public void test_BeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        UserService userService = new UserService();
        beanFactory.registerBeanDefinition("userservice",new BeanDefinition(userService));

        UserService userService1=(UserService) beanFactory.getBean("userservice");
        userService1.queryUserInfo();

    }


}
