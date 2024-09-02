package SpringIoc;

public class Test {

    public static void main(String[] args) {

        BeanFactory beanFactory = new BeanFactory();

        UserDao userDao = (UserDao) beanFactory.getBean("UserDao");
        userDao.queryUserInfo();
    }
}
