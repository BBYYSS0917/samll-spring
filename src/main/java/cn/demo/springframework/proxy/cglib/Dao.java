package cn.demo.springframework.proxy.cglib;

/**
 * @author BaiJY
 * @date 2023/06/19
 **/
public class Dao {

    public void update() {
        System.out.println("PeopleDao.update()");
    }

    public void select() {
        System.out.println("PeopleDao.select()");
    }
}