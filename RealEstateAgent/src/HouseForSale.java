public class HouseForSale extends House {
    public HouseForSale(String address, int price) {
        super(address, price);
    }

    @Override
    public double getCommission() {
        return getPrice() * 0.03;
    }

    @Override
    public String toString() {
        return "House for Sale\n%s".formatted(super.toString());
    }
}
