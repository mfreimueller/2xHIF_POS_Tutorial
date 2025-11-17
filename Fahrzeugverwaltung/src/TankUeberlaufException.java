public class TankUeberlaufException extends Exception {

    private String ort;

    public TankUeberlaufException(String message, String ort) {
        super(message);
        this.ort = ort;
    }

    public String getOrt() {
        return ort;
    }

    @Override
    public String toString() {
        return super.toString() + " beim Ort " + ort;
    }
}
