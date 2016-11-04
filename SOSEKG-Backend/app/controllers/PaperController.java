package controllers;

import models.Author;
import models.Paper;
import org.neo4j.ogm.session.Session;
import play.Logger;
import play.mvc.Result;
import utils.SessionUtils;

import java.util.List;
import java.util.Set;

import static play.mvc.Results.ok;

/**
 * Created by xnchen on 11/3/16.
 */
public class PaperController {

    public Result getAllPapers() {
        Session session = SessionUtils.getSession();
        Author author = new Author();
        author.setName("Test Author");
        session.save(author);
        Logger.info(author.getId() + "");
        return ok();
    }

    public Result countOfPaper() {
        Session session = SessionUtils.getSession();
        List<Paper> authorSet = (List<Paper>)session.loadAll(Paper.class);
        Logger.info(authorSet.size() + "");
        return ok();
    }

    public Result countOfAuthor() {
        Session session = SessionUtils.getSession();
        List<Author> authorSet = (List<Author>)session.loadAll(Author.class);
        Logger.info(authorSet.size() + "");
        return ok();
    }
}
