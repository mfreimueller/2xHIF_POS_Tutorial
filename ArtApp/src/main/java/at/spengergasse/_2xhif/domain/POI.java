package at.spengergasse._2xhif.domain;

import at.spengergasse._2xhif.domain.content.Content;
import at.spengergasse._2xhif.domain.content.FileContent;
import at.spengergasse._2xhif.domain.content.ImageContent;
import at.spengergasse._2xhif.foundation.exception.DataViolationException;

import java.util.ArrayList;
import java.util.List;

public class POI {
    private final Long id;
    private String title;
    private String description;
    private int year;

    private List<Content> contents = new ArrayList<>();

    public POI(Long id) {
        this.id = id;
    }

    public POI(Long id, String title, String description, int year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public POI(Long id, String title, String description, int year, List<Content> contents) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setTitle(String title) throws DataViolationException {
        if (title == null) {
            throw new DataViolationException("title must not be null!");
        } else if (title.isBlank()) {
            throw new DataViolationException("title must not be empty or blank!");
        }

        this.title = title;
    }

    public void setDescription(String description) throws DataViolationException {
        if (description == null) {
            throw new DataViolationException("description must not be null!");
        } else if (description.isBlank()) {
            throw new DataViolationException("description must not be empty or blank!");
        }

        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addContent(Content content) throws DataViolationException {
        if (content == null) {
            throw new DataViolationException("content to add must not be null!");
        }

        contents.add(content);
    }

    public void present() {
        for (Content content : contents) {
            if (content instanceof FileContent fileContent) {
                fileContent.load();
//                ((FileContent) content.load();
            }

            content.present();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        // <id> title (year)
        sb.append('<').append(id).append("> ");
        sb.append(title).append(" (");
        sb.append(year).append(')');

        return sb.toString();
    }
}
