package at.spengergasse._2xhif.domain.content;

public class VideoContent extends FileContent {

    private int duration;
    private int width, height;

    public VideoContent(Long id, String name, String description, String filePath) {
        super(id, name, description, filePath);
    }

    public int getDuration() {
        return duration;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void load() {
        super.load();

        // dummy values:
        duration = 120;
        width = 1920;
        height = 1080;
    }

    @Override
    public void present() {
        System.out.println("Playing video: " + getFilePath());
    }
}
