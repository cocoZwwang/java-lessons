package pres.cocoadel.web.mvc.listener;

import pres.cocoadel.web.mvc.context.ComponentContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * 初始化一些单例对象
 */
@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log("DBConnectionInitializerListener contextInitialized .......");
        ComponentContext context = new ComponentContext();
        context.init(servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log("DBConnectionInitializerListener contextDestroyed .......");
        ComponentContext componentContext = (ComponentContext) servletContextEvent.getServletContext()
                .getAttribute(ComponentContext.CONTEXT_NAME);
        componentContext.close();
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
