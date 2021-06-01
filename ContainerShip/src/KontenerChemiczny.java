public class KontenerChemiczny extends KontenerPrzemyslowy{
    boolean czyLatwopalne;
    boolean czyZrace;

    public KontenerChemiczny(int masa, String producent,String towar, boolean czyDelikatne, boolean  czyLatwopalne, boolean czyZrace) {
        super(masa, producent, towar, czyDelikatne);
        this.czyLatwopalne = czyLatwopalne;
        this.czyZrace = czyZrace;
    }

    public boolean isCzyLatwopalne() {
        return czyLatwopalne;
    }

    public void setCzyLatwopalne(boolean czyLatwopalne) {
        this.czyLatwopalne = czyLatwopalne;
    }

    public boolean isCzyZrace() {
        return czyZrace;
    }

    public void setCzyZrace(boolean czyZrace) {
        this.czyZrace = czyZrace;
    }
}
