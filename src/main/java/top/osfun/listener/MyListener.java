package top.osfun.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Jacky on 2019-01-12 15:00.
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.print("contextInitialized.........................................");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.print("contextDestroyed.........................................");
    }
}
