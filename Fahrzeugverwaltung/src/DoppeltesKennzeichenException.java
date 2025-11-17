public class DoppeltesKennzeichenException extends Exception {
    private final String kennzeichen;

    public DoppeltesKennzeichenException(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }
}
