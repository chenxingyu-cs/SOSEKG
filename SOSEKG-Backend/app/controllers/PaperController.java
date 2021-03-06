package controllers;

import models.Author;
import models.Paper;
import org.neo4j.ogm.session.Session;
import play.Logger;
import play.mvc.Result;
import utils.SessionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static play.mvc.Results.ok;

/**
 * Created by xnchen on 11/3/16.
 */
public class PaperController {

    public Result getAllPapers() {
        Session session = SessionUtils.getSessionFactory().openSession();
        Author author = new Author();
        author.setName("Test Author");
        session.save(author);
        return ok(author.getId() + "");
    }

    public Result countOfPaper() {
        Session session = SessionUtils.getSessionFactory().openSession();
        List<Paper> authorSet = (List<Paper>)session.loadAll(Paper.class);
        if (authorSet.size() > 0)
            Logger.info(authorSet.get(0).getId() + "");
        return ok(authorSet.size() + "");
    }

    public Result countOfAuthor() {
        Session session = SessionUtils.getSessionFactory().openSession();
        List<Author> authorSet = (List<Author>)session.loadAll(Author.class);
        return ok(authorSet.size() + "");
    }

    public Result paperAuthor(long id) {
        Session session = SessionUtils.getSessionFactory().openSession();

        Logger.info("haha" + id);
//        List<Paper> authorSet = (List<Paper>)session.loadAll(Paper.class);
//        Logger.info(authorSet.size() + "");
        Paper paper = session.load(Paper.class, id);
        if (paper != null) {
            List<String> nodes = new ArrayList<>();
            List<String> links = new ArrayList<>();
            nodes.add("{\"id\": \"" + paper.getTitle() + "\"}");
            Logger.info(paper.getTitle());
            Logger.info(paper.getAuthors().size() + "");
            for (Author au: paper.getAuthors()) {
                nodes.add("{\"id\": \"" + au.getName() + "\"}");
                links.add("{\"source\": \"" + au.getName() + "\", \"target\": \"" + paper.getTitle() + "\", \"value\": 1}");
            }

            Logger.info(nodes.toString());
            Logger.info(links.toString());
            String result = "{\"nodes\": " + nodes.toString() + ", \"link\": " + links.toString() + "}";
            return ok(result);
        }
        return ok();
    }

    public Result paperPaper(long id) {
        Session session = SessionUtils.getSessionFactory().openSession();

        Logger.info("haha" + id);
        Paper paper = session.load(Paper.class, id);
        if (paper != null) {
            List<String> nodes = new ArrayList<>();
            List<String> links = new ArrayList<>();
            nodes.add("{\"id\": \"" + paper.getTitle() + "\"}");
            Logger.info(paper.getTitle());
            Logger.info(paper.getAuthors().size() + "");
            for (Paper p: paper.getCiteMe()) {
                nodes.add("{\"id\": \"" + p.getTitle() + "\"}");
                links.add("{\"source\": \"" + p.getTitle() + "\", \"target\": \"" + paper.getTitle() + "\", \"value\": 1}");
            }

            for (Paper p: paper.getCiteOther()) {
                nodes.add("{\"id\": \"" + p.getTitle() + "\"}");
                links.add("{\"source\": \"" + paper.getTitle() + "\", \"target\": \"" + p.getTitle() + "\", \"value\": 1}");
            }

            Logger.info(nodes.toString());
            Logger.info(links.toString());
            String result = "{\"nodes\": " + nodes.toString() + ", \"link\": " + links.toString() + "}";
            return ok(result);
        }
        return ok();
    }

    public Result authorAuthor(long id) {
        Session session = SessionUtils.getSessionFactory().openSession();

        Logger.info("heihei" + id);
        Author author = session.load(Author.class, id);
        if (author != null) {
            List<String> nodes = new ArrayList<>();
            List<String> links = new ArrayList<>();
            Set<Paper> papers = author.getPapers();
            for (Paper paper : papers) {
                Logger.info("paper Title: " + paper.getTitle());
                Set<Author> authorSet = paper.getAuthors();
                Logger.info("author size: " + authorSet.size());
                for (Author co : authorSet) {
                    if (!co.getName().equals(author.getName())) {
                        nodes.add("{\"id\": \"" + co.getName() + "\"}");
                        links.add("{\"source\": \"" + author.getName() + "\", \"target\": \"" + co.getName() + "\", \"value\": 1}");
                    }
                }
            }
            Logger.info(nodes.toString());
            Logger.info(links.toString());
            String result = "{\"nodes\": " + nodes.toString() + ", \"link\": " + links.toString() + "}";
            return ok(result);
        }
        return ok();
    }
}
