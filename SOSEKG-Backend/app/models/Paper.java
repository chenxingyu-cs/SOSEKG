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
public class Paper {
    @GraphId
    private Long id;
    private int year;
    private String venue;
    private String abstractContent;
    private String title;

    @Relationship(type = "PUBLISH", direction = "INCOMING")
    private Set<Author> authors = new HashSet<>();

    @Relationship(type = "CITE", direction = "INCOMING")
    private Set<Paper> citeMe = new HashSet<>();

    @Relationship(type = "CITE", direction = "OUTCOMING")
    private Set<Paper> citeOther = new HashSet<>();

}
