package models;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xnchen on 11/3/16.
 */
@NodeEntity
@Getter
@Setter
public class Author {
    @GraphId
    private Long id;
    private String name;

    @Relationship(type = "PUBLISH", direction = "OUTGOING")
    private Set<Paper> papers = new HashSet<>();
}
