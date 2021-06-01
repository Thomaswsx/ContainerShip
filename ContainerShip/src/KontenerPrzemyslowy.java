public abstract class KontenerPrzemyslowy extends Kontener {
    boolean czyDelikatne;

    public KontenerPrzemyslowy(int masa, String producent,String towar, boolean czyDelikatne) {
        super(masa, producent, towar);
        this.czyDelikatne = czyDelikatne;
    }

    public boolean isCzyDelikatne() {
        return czyDelikatne;
    }

    public void setCzyDelikatne(boolean czyDelikatne) {
        this.czyDelikatne = czyDelikatne;
    }

}
