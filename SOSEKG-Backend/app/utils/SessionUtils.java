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

    private static Session session;

    public static synchronized Session getSession() {
        if (session == null) {
            Configuration configuration = new Configuration();
            configuration.driverConfiguration()
                    .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                    .setURI("http://neo4j:dxy@localhost:7474");

            SessionFactory sessionFactory = new SessionFactory(configuration, "models");
            session = sessionFactory.openSession();
        }
        return session;
    }

}
