package rechner.gui;

public class Schriftstueck extends Gegenstand {
	String inhalt;
	
	public Schriftstueck(int gewicht, String inhalt) {
		super(gewicht);
		this.inhalt = inhalt;
	}
}