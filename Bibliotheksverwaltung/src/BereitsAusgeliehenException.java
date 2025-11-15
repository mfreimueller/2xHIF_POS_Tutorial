public class BereitsAusgeliehenException extends Exception {
    private final String title;

    public BereitsAusgeliehenException(String message, String title) {
        super(message);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
