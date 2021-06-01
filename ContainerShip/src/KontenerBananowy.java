public class KontenerBananowy extends KontenerSpozywczy {
    int sredniaZgiecieBanana;

    public KontenerBananowy(int masa, String producent,String towar, int stalaTemperatura, String technologiaChlodzenia, int sredniaZgiecieBanana) {
        super(masa, producent,towar, stalaTemperatura, technologiaChlodzenia);
        this.sredniaZgiecieBanana = sredniaZgiecieBanana;
    }

    public int getSredniaZgiecieBanana() {
        return sredniaZgiecieBanana;
    }

    public void setSredniaZgiecieBanana(int sredniaZgiecieBanana) {
        this.sredniaZgiecieBanana = sredniaZgiecieBanana;
    }
}
