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
public class Author {
    @GraphId
    private Long id;
    private String name;

    @Relationship(type = "AUTHORS", direction = "OUTGOING")
    private Set<Paper> papers = new HashSet<>();
}
