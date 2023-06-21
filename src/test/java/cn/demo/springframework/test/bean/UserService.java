package cn.demo.springframework.test.bean;

public class UserService {
    private String uId;
    private UserDao userDao;
//    private String name;
//
//    public UserService(String name) {
//        this.name = name;
//    }

    public String queryUserInfo() {
        return "查询用户信息:" + userDao.queryUserName(uId);
//        System.out.println("查询用户信息:" + userDao.queryUserName(uId));
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("");
//        sb.append("").append(name);
//        return sb.toString();
//    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
