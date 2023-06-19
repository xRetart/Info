public class Statuswert {
    int wert;
    int maximum;

    public Statuswert(int wert, int maximum) {
        this.wert = wert;
        this.maximum = maximum;
    }

    public void erhoehen(int unterschied) {
        wert += unterschied;
        if (wert > maximum) {
            wert = maximum;
        }
    }

    public void abziehen(int unterschied) {
        wert -= unterschied;
        if (wert < 0) {
            wert = 0;
        }
    }
}
