public class Fahrrad extends  Fahrzeug {
    public Fahrrad(String marke, String modell, double tankinhalt, double tankkapazitaet, Kraftstoffart kraftstoffart) {
        super(marke, modell, tankinhalt, tankkapazitaet, kraftstoffart);
    }

    @Override
    public void hupen() {

    }
}
