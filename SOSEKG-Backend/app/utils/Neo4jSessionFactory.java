package utils;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * Created by xnchen on 11/3/16.
 */
public class Neo4jSessionFactory {
//    private static SessionFactory sessionFactory;
//    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();
//
//    public static Neo4jSessionFactory getInstance() {
//        if (factory == null) {
//            factory = new Neo4jSessionFactory();
//        }
//        return factory;
//    }
//
//    private Neo4jSessionFactory() {
//        Configuration configuration = new Configuration();
//        configuration.driverConfiguration()
//                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
//                .setURI("http://neo4j:dxy@localhost:7474");
//
//        sessionFactory = new SessionFactory(configuration, "models");
//    }
//
//    public Session getNeo4jSession() {
//        return sessionFactory.openSession();
//    }
}
