public class Konto {
    private int kontoStand;

    public Konto(int kontoStand) {
        this.kontoStand = kontoStand;
    }

    public synchronized void abheben(int betrag) {
        // +500
        // -300 <--
        // Gefahr: dead lock
        if (betrag > kontoStand) {
            throw new IllegalArgumentException("Cannot withdraw this amount of money!");
        }

        kontoStand -= betrag;

        System.out.println("Neuer Kontostand: " + kontoStand);
    }
}
