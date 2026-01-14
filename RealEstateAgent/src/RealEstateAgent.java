import java.util.HashSet;

public class RealEstateAgent {
    private HashSet<House> houses;

    public RealEstateAgent() {
        houses = new HashSet<>();
    }

    public void addHouse(House house) {
        if (house == null) {
            throw new IllegalArgumentException("house must not be null");
        }

        houses.add(house);
    }

    public double calculateCommission() {
        double sum = 0;

        for (House house : houses) {
            sum += house.getCommission();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Houses: \n\n");

        for (House house : houses) {
            sb.append(house).append("\n\n");
        }

        sb.append("Sum of commissions = ").append(calculateCommission());

        return sb.toString();
    }
}
