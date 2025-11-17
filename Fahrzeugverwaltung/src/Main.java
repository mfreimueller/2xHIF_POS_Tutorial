import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fahrzeug auto = new Auto("Auto", "", 0, 10, Kraftstoffart.BENZIN);
        Fahrzeug moped = new Motorrad("Auto", "", 0, 10, Kraftstoffart.BENZIN);

        List<Fahrzeug> garage = new ArrayList<Fahrzeug>();
        garage.add(auto);
        garage.add(moped);

        ((Auto) moped).hupen();

        try {
            auto.tanken(500);
        } catch (TankUeberlaufException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
    }
}