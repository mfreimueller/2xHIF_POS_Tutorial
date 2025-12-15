package at.spengergasse.santa.domain;

public abstract class AbstractEntity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
