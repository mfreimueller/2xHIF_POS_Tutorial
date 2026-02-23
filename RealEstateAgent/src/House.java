public abstract class House {
    private String address;
    private int price;

    public House(String address, int price) {
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }

    public abstract double getCommission();

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("address = ").append(address).append('\n');
//        sb.append("price = ").append(price);
//
//        return sb.toString();

        return "address = %s\nprice = %d".formatted(address, price);
    }
}
