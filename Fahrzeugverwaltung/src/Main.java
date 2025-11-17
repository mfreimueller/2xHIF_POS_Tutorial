
public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("Citrœn", "C4", 20, 60, Kraftstoffart.DIESEL);
        Motorrad motorrad = new Motorrad("Yamaha", "Ténéré 700", 15, 16, Kraftstoffart.BENZIN);

        auto.hupen();
        motorrad.hupen();

        try {
            // das wird funktionieren, da (20 + 40) <= 60
            auto.tanken(40);
        } catch (TankUeberlaufException e) {
            System.err.println(e.getMessage() + " in " + e.getOrt());
        }

        try {
            // das wird scheitern, da (15+2) > 16
            auto.tanken(2);
        } catch (TankUeberlaufException e) {
            System.err.println(e.getMessage() + " in " + e.getOrt());
        }

        /*
        Erstelle eine Garage und parke beide Fahrzeuge ein.
        Parke dann das Motorrad zweimal aus - das zweite Mal darf nicht funktionieren (i.e. muss null zurückliefern)!
         */

        Garage garage = new Garage();

        try {
            garage.parkeEin("BN-123FM", auto);
            garage.parkeEin("W-54XZ", motorrad);
        } catch (DoppeltesKennzeichenException e) {
            // das wird nie passieren (oder sollte nicht)
            assertThat(true, "Konnte eindeutige Kennzeichen nicht richtig parken!");
        }

        try {
            // das wird scheitern!
            garage.parkeEin("BN-123FM", motorrad);
        } catch (DoppeltesKennzeichenException e) {
            System.out.println("Ein Fahrzeug mit dem Kennzeichen " + e.getKennzeichen() + " steht schon in der Garage!");
        }

        Fahrzeug ausgeparkt = garage.parkeAus("W-54XZ");
        assertThat((ausgeparkt != null), "Das Fahrzeug mit dem Kennzeichen W-54XZ konnte nicht ausgeparkt werden!");

        Fahrzeug gibtEsNicht = garage.parkeAus("W-54XZ");
        assertThat((gibtEsNicht == null), "Das Fahrzeug mit dem Kennzeichen W-54XZ konnte doppelt ausgeparkt werden!");

        assertThat(garage.hatFahrzeugMitKennzeichen("BN-123FM"), "Das Fahrzeug mit dem Kennzeichen wurde nicht gefunden, obwohl es in der Garage steht!");

        try {
            // das wird funktionieren, obwohl das Auto bereits eingeparkt ist, weil wir es mit einem anderen Kennzeichen
            // parken.
            garage.parkeEin("W-5432WW", auto);
        } catch (DoppeltesKennzeichenException e) {
            // das sollte nicht passieren!
            assertThat(true, "Konnte eindeutige Kennzeichen nicht richtig parken!");
        }
    }

    /**
     * Eine Hilfsfunktion, die eine Exception wird, wenn die Bedingung `mustBeTrue` false ist. Dann wird `orElse` ausgegeben.
     */
    private static void assertThat(boolean mustBeTrue, String orElse) {
        if (!mustBeTrue) {
            throw new IllegalStateException(orElse);
        }
    }
}