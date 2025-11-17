public class Motorrad extends Fahrzeug {
    public Motorrad(String marke, String modell, double tankinhalt, double tankkapazitaet, Kraftstoffart kraftstoffart) {
        super(marke, modell, tankinhalt, tankkapazitaet, kraftstoffart);
    }

    @Override
    public void hupen() {
        System.out.println("Motorrad hupt: MEEP MEEP!");
    }

    public void weelie() {

    }
}
