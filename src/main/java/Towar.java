public class Towar {
    public String nazwa;
    public double cena;
    public Towar(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }
    @Override
    public String toString() {
        return nazwa + " w cenie: " + String.format("%.2f zł", cena);
    }
}
