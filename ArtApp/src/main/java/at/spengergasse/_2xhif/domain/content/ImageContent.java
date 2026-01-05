package at.spengergasse._2xhif.domain.content;

public class ImageContent extends FileContent {

    private int width, height;

    public ImageContent(Long id, String name, String description, String filePath) {
        super(id, name, description, filePath);
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
        width = 256;
        height = 128;
    }

    @Override
    public void present() {
        System.out.println("Displaying image: " + getFilePath());
    }
}
