public class Spieler {
    private Gegenstand hand;
    private Inventar inventar;
    private Statuswert saettigung = new Statuswert(100, 100);
    private Statuswert leben = new Statuswert(100, 100);

    public Spieler(int inventarMaxGewicht, int inventarKapazitaet) {
        hand = null;
        inventar = new Inventar(inventarMaxGewicht, inventarKapazitaet);
    }

    public Gegenstand ausgeruested() {
        return hand;
    }

    public boolean ausruesten(int gegenstandPosition) {
        Gegenstand vorher = hand;
        Gegenstand nachher = inventar.entnehmen(gegenstandPosition);
        if (nachher == null) {
            return false;
        }
        if (vorher != null) {
            inventar.lagern(vorher);
        }
        hand = nachher;

        return true;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public boolean ausfuehren(Truhe truhe) {
        if (hand == null) {
            return false;
        }

        if (hand instanceof Essen) {
            saettigung.erhoehen(((Essen) hand).getSaettigung());
            leben.erhoehen(((Essen) hand).getRegeneration());
            hand = null;
            return true;
        } else if (hand instanceof Schriftstueck) {
            System.out.println(((Schriftstueck) hand).lesen());
            return true;
        } else if (hand instanceof Schluessel) {
            return truhe.aufschliessen((Schluessel) hand);
        } else {
            System.out.println("Gegenstand typ ist nicht für ausführen implementiert.");
            return false;
        }
    }

    public void ausgeben() {
        System.out.println("Spieler:");
        System.out.print("Spieler hat ");
        if (hand == null) {
            System.out.print("nichts");
        } else {
            hand.ausgeben();
        }
        System.out.println(" in der hand.");
        inventar.ausgeben();
    }
}
