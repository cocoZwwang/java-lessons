package pres.cocoadel.web.mvc.listener;

import pres.cocoadel.web.mvc.context.ComponentContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(TestListener.class.getName());

    private static final String COMPONENT_ENV_CONTEXT_NAME = "java:comp/env";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log("TestListener contextInitialized .......");
        ComponentContext context = new ComponentContext();
        context.init(servletContextEvent.getServletContext());
//        DataSource dataSource = context.getComponent("jdbc/UserPlatformDB",DataSource.class);
//        getConnection(dataSource);
//
//        DBConnectionManager connectionManager =
//                context.getComponent("bean/DBConnectionManager", DBConnectionManager.class);
//        connectionManager.init();
        testPropertiesFromJNDI(context,servletContextEvent.getServletContext());
        testPropertiesFromServletConfig(servletContextEvent.getServletContext());
    }

    private void testPropertiesFromJNDI(ComponentContext componentContext, ServletContext servletContext){
        Integer maxValue = componentContext.getComponent("maxValue", Integer.class);
        servletContext.log("++++++++++++++maxValue: " + maxValue);
    }

    private void testPropertiesFromServletConfig(ServletContext servletContext) {
        String appName = servletContext.getInitParameter("application.name");
        servletContext.log("------------application.name: " + appName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private Connection getConnection(DataSource dataSource) {
        // 依赖查找
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        if (connection != null) {
            logger.log(Level.INFO, "获取 JNDI 数据库连接成功！");
        }
        return connection;
    }
}
