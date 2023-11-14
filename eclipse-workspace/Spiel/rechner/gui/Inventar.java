package rechner.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventar extends JFrame {
	ArrayList<Gegenstand> gegenstaende = new ArrayList<>(Arrays.asList(new Nahrung(10, 20, "Fischbrötchen"), new Schriftstueck(10, "Eine geheime Botschaft")));
	Vector<String> inventar = new Vector<>();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventar frame = new Inventar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inventar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		for (var gegenstand : gegenstaende) {
			inventar.add(gegenstand.darstellen());
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNehmen = new JButton("Nehmen");
		btnNehmen.setBounds(301, 38, 105, 27);
		contentPane.add(btnNehmen);
		
		JButton btnBenutzen = new JButton("Benutzen");
		btnBenutzen.setBounds(301, 94, 105, 27);
		contentPane.add(btnBenutzen);
		
		JButton btnWegwerfen = new JButton("Wegwerfen");
		btnWegwerfen.setBounds(301, 150, 105, 27);
		contentPane.add(btnWegwerfen);
		
		var comboBox = new JComboBox<>(inventar);
		comboBox.setBounds(12, 38, 159, 26);
		contentPane.add(comboBox);
		
		JLabel lblIteminfo = new JLabel("");
		lblIteminfo.setBounds(12, 94, 170, 17);
		contentPane.add(lblIteminfo);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var index = comboBox.getSelectedIndex();
				var gegenstand = gegenstaende.get(index);
				
				if (gegenstand instanceof Nahrung) {
					var nahrung = (Nahrung)gegenstand;
					lblIteminfo.setText(nahrung.name + " bringt " + nahrung.lebenspunkte + " Lebenspunkte." + " (" + nahrung.gewicht + "g)");
				}
				else if (gegenstand instanceof Schriftstueck) {
					var schriftstueck = (Schriftstueck)gegenstand;
					lblIteminfo.setText("Auf dem Schriftstück steht: " + schriftstueck.inhalt + ". (" + schriftstueck.gewicht + "g)");
				}
				else {
					System.err.println("Den Gegenstand gibt es nicht.");
				}
			}
		});
		btnInfo.setBounds(301, 207, 105, 27);
		contentPane.add(btnInfo);
	}
}
