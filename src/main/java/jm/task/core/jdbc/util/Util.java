package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.Properties;

@Transactional
public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    private static SessionFactory sessionFactory = null;


    public Util() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            System.err.println("Не удалось подключиться к серверу");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            System.err.println("Не удалось подключиться к серверу из метода getConnection");
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getHybConnection() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            Properties prop = new Properties();

            try {
                prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                prop.put(Environment.URL, URL);
                prop.put(Environment.USER, USER);
                prop.put(Environment.PASS, PASSWORD);

                prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                prop.put(Environment.HBM2DDL_AUTO, "");

                config.setProperties(prop);
                config.addAnnotatedClass(User.class);

                ServiceRegistry sr = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties())
                        .build();
                sessionFactory = config.buildSessionFactory(sr);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
