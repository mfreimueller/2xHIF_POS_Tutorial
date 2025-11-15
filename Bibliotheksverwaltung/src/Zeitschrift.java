public class Zeitschrift extends Medium {
    private int ausgabeNummer;

    public Zeitschrift(String title, int erscheinungsjahr, int ausgabeNummer) {
        super(title, null, erscheinungsjahr, MediumType.Zeitschrift);
        this.ausgabeNummer = ausgabeNummer;
    }

    public int getAusgabeNummer() {
        return ausgabeNummer;
    }

    public void setAusgabeNummer(int ausgabeNummer) {
        this.ausgabeNummer = ausgabeNummer;
    }

    @Override
    public String info() {
        return "Zeitschrift: " + title + " Ausgabe " + ausgabeNummer +
                "(" + erscheinungsjahr + ")";
    }
}
