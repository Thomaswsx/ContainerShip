public class KontenerZElektronika extends KontenerPrzemyslowy {

    boolean czyWymagaZasilania;

    public KontenerZElektronika(int masa, String producent, String towar, boolean czyDelikatne, boolean czyWymagaZasilania) {
        super(masa, producent, towar, czyDelikatne);
        this.czyWymagaZasilania = czyWymagaZasilania;
    }

    public boolean isCzyWymagaZasilania() {
        return czyWymagaZasilania;
    }

    public void setCzyWymagaZasilania(boolean czyWymagaZasilania) {
        this.czyWymagaZasilania = czyWymagaZasilania;
    }
}
