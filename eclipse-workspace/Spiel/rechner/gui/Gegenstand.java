package rechner.gui;

public abstract class Gegenstand {
	int gewicht;
	
	public Gegenstand(int gewicht) {
		this.gewicht = gewicht;
	}
	
	public abstract String darstellen();
}