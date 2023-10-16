package rechner.gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Speicher {
	String path;
	
	public Speicher(String path) {
		this.path = path;
	}
	public ArrayList<Daten> laden() {
		try {
			var stream = new ObjectInputStream(new FileInputStream(path));
			var daten = (ArrayList<Daten>) stream.readObject();
			stream.close();
			return daten;
		}
		catch (ClassNotFoundException _e) {
			System.err.println("Klasse wurde nicht gefunden.");
			return null;
		}
		catch (IOException _e) {
			return null;
		}
	}
	public void speichern(ArrayList<Daten> daten) {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path));
			stream.writeObject(daten);
			stream.close();
		}
		catch (IOException _e) {
			System.err.println("Konnte File nicht öffnen.");
		}
	}
}