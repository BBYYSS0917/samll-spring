package cn.demo.springframework.test.cglib;

import cn.demo.springframework.proxy.cglib.Dao;
import cn.demo.springframework.proxy.cglib.DaoAnotherProxy;
import cn.demo.springframework.proxy.cglib.DaoFilter;
import cn.demo.springframework.proxy.cglib.DaoProxy;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class CglibTest {
    @Test
    public void testCglib() {
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy, daoAnotherProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());

        Dao dao = (Dao)enhancer.create();
        dao.update();
        dao.select();
    }
}
