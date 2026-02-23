public class HouseToLet extends House {
    public HouseToLet(String address, int price) {
        super(address, price);
    }

    @Override
    public double getCommission() {
        return getPrice() * 3;
    }

    @Override
    public String toString() {
        return "House to Let\n%s".formatted(super.toString());
    }
}
