package at.spengergasse._2xhif.domain.content;

public abstract class FileContent extends Content {

    private final String filePath;

    public FileContent(Long id, String name, String description, String filePath) {
        super(id, name, description);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void load() {
        System.out.println("Loading file: " + filePath);
    }
}
