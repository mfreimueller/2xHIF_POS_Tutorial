public class Auto extends Fahrzeug {
    public Auto(String marke, String modell, double tankinhalt, double tankkapazitaet, Kraftstoffart kraftstoffart) {
        super(marke, modell, tankinhalt, tankkapazitaet, kraftstoffart);

    }

    @Override
    public void hupen() {
        System.out.println("Auto hupt: Hup Hup!");
    }
}
