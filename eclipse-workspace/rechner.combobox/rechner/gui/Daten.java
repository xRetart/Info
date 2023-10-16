package rechner.gui;

import java.io.Serializable;

public class Daten implements Serializable {
	String name;
	int alter;
	Geschlecht geschlecht;
	Farbe augenfarbe;
	Farbe haarfarbe;
	String beruf;
	String nationalitaet;
	
	public Daten(String name, int alter, Geschlecht geschlecht, Farbe augenfarbe, Farbe haarfarbe, String beruf, String nationalitaet) {
		this.name = name;
		this.alter = alter;
		this.geschlecht = geschlecht;
		this.haarfarbe = haarfarbe;
		this.augenfarbe = augenfarbe;
		this.beruf = beruf;
		this.nationalitaet= nationalitaet;
	}
}