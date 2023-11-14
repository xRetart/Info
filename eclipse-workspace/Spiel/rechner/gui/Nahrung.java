package rechner.gui;

public class Nahrung extends Gegenstand {
	int lebenspunkte;
	String name;
	
	public Nahrung(int gewicht, int lebenspunkte, String name) {
		super(gewicht);
		this.lebenspunkte = lebenspunkte;
		this.name = name;
	}

	@Override
	public String darstellen() {
		return name.
	}
}