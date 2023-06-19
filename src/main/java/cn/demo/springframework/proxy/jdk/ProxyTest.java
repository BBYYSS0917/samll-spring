package cn.demo.springframework.proxy.jdk;

import javax.xml.ws.Service;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class ProxyTest {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
//        DebugProxy debugProxy = new DE(new SmsServiceImpl());
//        SmsService smsService = debugProxy.getProxy(SmsService.class);
//        smsService.send("java");

        SmsService target=(SmsService) JdkProxyFactory.getProxy(smsService);

        target.send("world");
    }
}
