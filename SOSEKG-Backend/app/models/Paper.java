package models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xnchen on 11/3/16.
 */
@NodeEntity
public class Paper {
    @GraphId
    private Long id;
    private String titile;
    private String volume;
    private String ee;
    private String pages;
    private String year;
    private String url;
    private String journal;

    @Relationship(type = "AUTHORS", direction = "INCOMING")
    private Set<Author> authors = new HashSet<>();
}
