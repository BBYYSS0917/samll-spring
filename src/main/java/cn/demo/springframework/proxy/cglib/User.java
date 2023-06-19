package cn.demo.springframework.proxy.cglib;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class User {
    public String say(String msg) {
        System.out.println("早上好" + msg);
        return msg;
    }
}
