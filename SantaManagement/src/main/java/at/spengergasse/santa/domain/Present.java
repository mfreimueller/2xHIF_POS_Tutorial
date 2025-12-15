package at.spengergasse.santa.domain;

public class Present {
    private Long id;
    private Priority priority;
    private Status status = Status.OPEN;

    public Present() {}

    public Present(Priority priority) {
        this.priority = priority;
    }

    public Present(Long id, Priority priority, Status status) {
        this.id = id;
        this.priority = priority;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum Status {
        OPEN,
        IN_PROGRESS,
        DONE
    }
}
