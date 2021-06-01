public abstract class Kontener {
    int masa;
    String producent;
    String towar;

    public Kontener(int masa, String producent, String towar) {
        this.masa = masa;
        this.producent = producent;
        this.towar = towar;
    }

    public int getMasa() {
        return masa;
    }

    public String getProducent() {
        return producent;
    }

    public String getTowar() {
        return towar;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public void setTowar(String towar) {
        this.towar = towar;
    }

    @Override
    public String toString() {
        return "Kontener{" +
                "masa=" + masa +
                ", producent='" + producent + '\'' +
                ", towar='" + towar + '\'' +
                '}';
    }
}
