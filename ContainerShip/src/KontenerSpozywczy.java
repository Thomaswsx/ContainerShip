public abstract class KontenerSpozywczy extends Kontener {
    int stalaTemperatura;
    String technologiaChlodzenia;


    public KontenerSpozywczy(int masa, String producent,String towar, int stalaTemperatura, String technologiaChlodzenia) {
        super(masa, producent, towar);
        this.stalaTemperatura = stalaTemperatura;
        this.technologiaChlodzenia = technologiaChlodzenia;
    }

    public int getStalaTemperatura() {
        return stalaTemperatura;
    }

    public void setStalaTemperatura(int stalaTemperatura) {
        this.stalaTemperatura = stalaTemperatura;
    }

    public String getTechnologiaChlodzenia() {
        return technologiaChlodzenia;
    }

    public void setTechnologiaChlodzenia(String technologiaChlodzenia) {
        this.technologiaChlodzenia = technologiaChlodzenia;
    }
}
