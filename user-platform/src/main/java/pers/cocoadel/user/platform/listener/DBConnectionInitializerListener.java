package pers.cocoadel.user.platform.listener;

import pers.cocoadel.user.platform.bean.SingletonBeanContainer;
import pers.cocoadel.user.platform.domain.User;
import pers.cocoadel.user.platform.jdbc.DBConnectionManager;
import pers.cocoadel.user.platform.jdbc.JdbcHelper;
import pers.cocoadel.user.platform.repository.DBUserRepository;
import pers.cocoadel.user.platform.repository.UserRepository;
import pers.cocoadel.user.platform.service.UserService;
import pers.cocoadel.user.platform.service.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 初始化一些单例对象
 */
@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(JdbcHelper.class.getName());

    public DBConnectionInitializerListener() {
        logger.log(Level.SEVERE, " DBConnectionInitializerListener constructor called。。。。。。");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.log(Level.SEVERE, " DBConnectionInitializerListener contextInitialized。。。。。");
        SingletonBeanContainer singletonBeanContainer = SingletonBeanContainer.getInstance();

        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        singletonBeanContainer.put(DBConnectionManager.class, dbConnectionManager);

        JdbcHelper jdbcHelper = new JdbcHelper(dbConnectionManager);
        singletonBeanContainer.put(JdbcHelper.class, jdbcHelper);

        UserRepository userRepository = new DBUserRepository();
        singletonBeanContainer.put(UserRepository.class, userRepository);

        UserService userService = new UserServiceImpl();
        singletonBeanContainer.put(UserService.class, userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        SingletonBeanContainer singletonBeanContainer = SingletonBeanContainer.getInstance();
        DBConnectionManager dbConnectionManager = singletonBeanContainer.get(DBConnectionManager.class);
        dbConnectionManager.releaseConnection();
        singletonBeanContainer.clear();
    }

//    public static void main(String[] args) {
//        DBConnectionInitializerListener listener = new DBConnectionInitializerListener();
//        listener.contextInitialized(null);
//
//        SingletonBeanContainer container = SingletonBeanContainer.getInstance();
//        UserRepository userRepository = container.get(UserRepository.class);
//
//        User newUser = new User();
//        newUser.setName("cocoAdel");
//        newUser.setEmail("cocoadel@193.com");
//        newUser.setPassword("123");
//        newUser.setPhoneNumber("169334568792");
//        userRepository.save(newUser);
//
//        Collection<User> users = userRepository.getAll();
//        for (User user : users){
//            logger.log(Level.INFO, user.toString());
//        }
//    }
}
