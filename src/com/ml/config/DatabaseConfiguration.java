package com.ml.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ml.pojo.Catagory;

public class DatabaseConfiguration {
	static SessionFactory sessionFactory=null;
	static {
		try {
			Configuration cfg=new Configuration();
			cfg.addAnnotatedClass(Catagory.class);

			Properties properties=new Properties();
			properties.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
			properties.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
			properties.put(Environment.USER, "system");
			properties.put(Environment.PASS, "68921794");
			properties.put(Environment.SHOW_SQL, "true");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.Oracle12cDialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			cfg.setProperties(properties);
			StandardServiceRegistryBuilder ssrBuilder=new StandardServiceRegistryBuilder();
			ServiceRegistry sr=ssrBuilder.applySettings(cfg.getProperties()).build();
			sessionFactory=cfg.buildSessionFactory(sr);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
