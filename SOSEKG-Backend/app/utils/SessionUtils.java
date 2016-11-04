package utils;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import javax.inject.Singleton;

/**
 * Created by xnchen on 11/3/16.
 */
@Singleton
public class SessionUtils {

    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.driverConfiguration()
                    .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                    .setURI("http://neo4j:qwe@hawking.sv.cmu.edu:7474");

            sessionFactory = new SessionFactory(configuration, "models");
        }
        return sessionFactory;
    }

}
