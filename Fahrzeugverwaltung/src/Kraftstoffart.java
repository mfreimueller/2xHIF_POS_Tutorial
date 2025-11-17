public enum Kraftstoffart {
    BENZIN(false),
    DIESEL(false),
    ELEKTRO(true);

    private final boolean umweltfreundlich;

    Kraftstoffart(boolean umweltfreundlich) {
        this.umweltfreundlich = umweltfreundlich;
    }

    public boolean isUmweltfreundlich() {
        return umweltfreundlich;
    }
}
