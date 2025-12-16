package _2xhif.domain;

import at.spengergasse._2xhif.foundation.exception.DataViolationException;

public class POI {
    private final Long id;
    private String title;
    private String description;
    private int year;

    public POI(Long id) {
        this.id = id;
    }

    public POI(Long id, String title, String description, int year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
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
