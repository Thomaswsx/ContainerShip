public class KontenerZSokami extends KontenerSpozywczy {
    String rodzajPojemnika;

    public KontenerZSokami(int masa, String producent, String towar, int stalaTemperatura, String technologiaChlodzenia, String rodzajPojemnika) {
        super(masa, producent, towar, stalaTemperatura, technologiaChlodzenia);
        this.rodzajPojemnika = rodzajPojemnika;
    }

    public String getRodzajPojemnika() {
        return rodzajPojemnika;
    }

    public void setRodzajPojemnika(String rodzajPojemnika) {
        this.rodzajPojemnika = rodzajPojemnika;
    }
}
