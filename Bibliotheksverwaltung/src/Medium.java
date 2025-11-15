public abstract class Medium {

    protected String title;
    protected String author;
    protected int erscheinungsjahr;
    protected final MediumType mediumType;

    public Medium(String title, String author, int erscheinungsjahr, MediumType mediumType) {
        this.author = author;
        this.erscheinungsjahr = erscheinungsjahr;
        this.mediumType = mediumType;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public MediumType getMediumType() {
        return mediumType;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String info();

}
