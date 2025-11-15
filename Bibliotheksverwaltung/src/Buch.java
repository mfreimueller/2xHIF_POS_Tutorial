public class Buch extends Medium {

    private int seitenzahl;

    public Buch(String title, String author, int erscheinungsjahr, int seitenzahl) {
        // unsichtbar, von Compiler eingefügt: super();

        // wir müssen den Konstruktor von Medium aufrufen:
        super(title, author, erscheinungsjahr, MediumType.Buch);

        this.seitenzahl = seitenzahl;
    }

    public int getSeitenzahl() {
        return seitenzahl;
    }

    public void setSeitenzahl(int seitenzahl) {
        this.seitenzahl = seitenzahl;
    }

    @Override
    public String info() {
        return "Buch: " + title + " von " + author + " (" +
                erscheinungsjahr + "), " + seitenzahl + " Seiten";
    }
}
