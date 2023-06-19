package cn.demo.springframework.proxy.jdk;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String msg) {
        System.out.println("send message:" + msg);
        return msg;
    }
}
