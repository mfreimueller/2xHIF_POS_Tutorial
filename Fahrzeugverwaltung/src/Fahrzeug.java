public abstract class Fahrzeug {

    protected String marke;
    protected String modell;
    protected double tankinhalt; // Aktueller Tankinhalt in Litern
    protected double tankkapazitaet; // Maximale Tankgröße
    protected Kraftstoffart kraftstoffart;

    public Fahrzeug(String marke, String modell, double tankinhalt, double tankkapazitaet, Kraftstoffart kraftstoffart) {
        this.marke = marke;
        this.modell = modell;

        setTankinhalt(tankinhalt);

        this.tankkapazitaet = tankkapazitaet;
        this.kraftstoffart = kraftstoffart;
    }

    public abstract void hupen();

    public void tanken(double liter) throws TankUeberlaufException {
        if (tankkapazitaet < liter + tankinhalt) {
            throw new TankUeberlaufException("Zu viel Sprit!", "tanken()");
        }

        tankinhalt += liter;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public double getTankinhalt() {
        return tankinhalt;
    }

    public void setTankinhalt(double tankinhalt) {
        if (tankinhalt < 0) {
            throw new IllegalArgumentException("Tankinhalt is negative");
        }

        this.tankinhalt = tankinhalt;
    }

    public double getTankkapazitaet() {
        return tankkapazitaet;
    }

    public void setTankkapazitaet(double tankkapazitaet) {
        this.tankkapazitaet = tankkapazitaet;
    }

    public Kraftstoffart getKraftstoffart() {
        return kraftstoffart;
    }

    public void setKraftstoffart(Kraftstoffart kraftstoffart) {
        this.kraftstoffart = kraftstoffart;
    }
}
