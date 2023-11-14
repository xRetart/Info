public class Spieler {
    private Gegenstand hand;
    private Inventar inventar;
    private Statuswert nahrung;
    private Statuswert leben;

    public Spieler(int inventarMaxGewicht, int inventarKapazitaet, int nahrung, int saettigung) {
        hand = null;
        inventar = new Inventar(inventarMaxGewicht, inventarKapazitaet);

        this.nahrung = new Statuswert(nahrung, 100);
        this.leben = new Statuswert(saettigung, 100);
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
    public void abruesten() {
        if (hand == null) {
            System.out.println("Der Spieler hat nichts in der Hand.");
            return;
        }
        if (inventar.lagern(hand)) {
            hand = null;
            System.out.println("Gegenstand wurde abgerüstet.");
        } else {
            System.out.println("Im Inventar ist nicht genug Platz um den Gegenstand zu lagern.");
        }
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void ausfuehren(Truhe truhe) {
        if (hand == null) {
            return;
        }

        if (hand instanceof Essen) {
            essen((Essen)hand);
        } else if (hand instanceof Schriftstueck) {
            lesen((Schriftstueck)hand);
        } else if (hand instanceof Schluessel) {
            schliessen((Schluessel)hand, truhe);
        } else {
            System.out.println("Gegenstandtyp ist nicht ausführbar.");
        }
    }
    public void essen(Essen essen) {
        nahrung.erhoehen(((Essen) hand).getSaettigung());
        leben.erhoehen(((Essen) hand).getRegeneration());
        hand = null;

        System.out.println("Das Essen wurde gegessen.");
    }
    public void lesen(Schriftstueck schriftstueck) {
        System.out.println("Auf dem Schriftstueck steht: \"" + ((Schriftstueck) hand).lesen() + '"');
    }
    public void schliessen(Schluessel schluessel, Truhe truhe) {
        boolean erfolg = truhe.schliessen((Schluessel) hand);

        if (!erfolg) {
            System.out.println("Die Schlüsselform (\"" + schluessel.form() + "\") passt nicht zu der Schlossform (\"" + truhe.getSchlossForm() + "\").");
        } else if (truhe.istVerschlossen()) {
            System.out.println("Die Truhe wurde verschlossen.");
        } else {
            System.out.println("Die Truhe wurde geöffnet.");
        }
    }

    public void ausgeben() {
        System.out.println("Spieler:");
        System.out.print("\t- hat ");
        if (hand == null) {
            System.out.print("nichts");
        } else {
            hand.ausgeben();
        }
        System.out.println(" in der hand.");

        System.out.println("\t- hat " + nahrung.wert + " von " + nahrung.maximum + " Nahrungspunkten");
        System.out.println("\t- hat " + leben.wert + " von " + leben.maximum + " Lebenspunkten.");

        inventar.ausgeben();
    }
}
