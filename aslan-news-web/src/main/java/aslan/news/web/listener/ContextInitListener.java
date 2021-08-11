package aslan.news.web.listener;

import com.chahan.domain.config.DbConnectionConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ResourceBundle;

@WebListener
public class ContextInitListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("db-connection-hikari");
            DbConnectionConfig.configure(bundle);
        } catch (Exception e) {
            throw new RuntimeException("Datasource initialization error", e);
        }
    }
}


