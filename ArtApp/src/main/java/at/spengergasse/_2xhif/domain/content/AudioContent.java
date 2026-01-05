package at.spengergasse._2xhif.domain.content;

public class AudioContent extends FileContent {

    private int duration;

    public AudioContent(Long id, String name, String description, String filePath) {
        super(id, name, description, filePath);
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void load() {
        super.load();

        // dummy values:
        duration = 60;
    }

    @Override
    public void present() {
        System.out.println("Playing audio: " + getFilePath());
    }
}
