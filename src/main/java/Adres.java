import com.google.gson.annotations.Expose;

public class Adres {
    @Expose
    private String miasto;
    @Expose
    private String ulica;
    @Expose
    private String kodPocztowy;
    public Adres() {
        miasto = "";
        ulica = "";
        kodPocztowy = "";
    }
    public Adres(String miasto, String ulica, String kod) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kod;
    }
    @Override
    public String toString() {
        return getMiasto() + " " + ulica + " " + kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }
}