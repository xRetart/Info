package rechner.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JList;

public class Window {
	private JFrame frame;
	private JTextField feldName;
	private JTextField berufFeld;
	private JTextField nationalitaetFeld;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					var window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		feldName = new JTextField();
		feldName.setBounds(145, 11, 200, 24);
		frame.getContentPane().add(feldName);
		feldName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 14, 60, 17);
		frame.getContentPane().add(lblName);
		
		JLabel lblAlter = new JLabel("Alter");
		lblAlter.setBounds(26, 55, 60, 17);
		frame.getContentPane().add(lblAlter);
		
		JSlider sliderAlter = new JSlider();
		sliderAlter.setMaximum(80);
		sliderAlter.setMinimum(10);
		sliderAlter.setBounds(145, 55, 200, 16);
		frame.getContentPane().add(sliderAlter);
		
		JLabel lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setBounds(26, 107, 71, 17);
		frame.getContentPane().add(lblGeschlecht);
		
		JComboBox<Geschlecht> auswahlGeschlecht = new JComboBox<Geschlecht>();
		auswahlGeschlecht.setBounds(145, 102, 114, 26);
		auswahlGeschlecht.setModel(new DefaultComboBoxModel<Geschlecht>(Geschlecht.values()));
		frame.getContentPane().add(auswahlGeschlecht);
		
		JLabel lblAugenfarbe = new JLabel("Augenfarbe");
		lblAugenfarbe.setBounds(26, 158, 90, 17);
		frame.getContentPane().add(lblAugenfarbe);
		
		JComboBox<Farbe> auswahlAugenfarbe = new JComboBox<Farbe>();
		auswahlAugenfarbe.setBounds(145, 153, 114, 26);
		auswahlAugenfarbe.setModel(new DefaultComboBoxModel<Farbe>(Farbe.values()));
		frame.getContentPane().add(auswahlAugenfarbe);
		
		JLabel lblHaarfarbe = new JLabel("Haarfarbe");
		lblHaarfarbe.setBounds(26, 203, 71, 17);
		frame.getContentPane().add(lblHaarfarbe);
		
		JComboBox<Farbe> auswahlHaarfarbe = new JComboBox<Farbe>();
		auswahlHaarfarbe.setModel(new DefaultComboBoxModel<Farbe>(Farbe.values()));
		auswahlHaarfarbe.setBounds(145, 198, 114, 26);
		frame.getContentPane().add(auswahlHaarfarbe);
		
		JLabel lblBeruf = new JLabel("Beruf");
		lblBeruf.setBounds(26, 252, 60, 17);
		frame.getContentPane().add(lblBeruf);
		
		berufFeld = new JTextField();
		berufFeld.setBounds(145, 250, 114, 21);
		frame.getContentPane().add(berufFeld);
		berufFeld.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nationalität");
		lblNewLabel.setBounds(26, 304, 90, 17);
		frame.getContentPane().add(lblNewLabel);
		
		nationalitaetFeld = new JTextField();
		nationalitaetFeld.setBounds(145, 302, 114, 21);
		frame.getContentPane().add(nationalitaetFeld);
		nationalitaetFeld.setColumns(10);
		
		
		JLabel warnungFeld = new JLabel("");
		warnungFeld.setBounds(145, 372, 249, 17);
		frame.getContentPane().add(warnungFeld);
		
		JList ausgabeListe = new JList();
		ausgabeListe.setBounds(53, 435, 1, 1);
		frame.getContentPane().add(ausgabeListe);
		

		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var name = feldName.getText();
				var alter = sliderAlter.getValue();
				var geschlecht = (Geschlecht)auswahlGeschlecht.getSelectedItem();
				var haarfarbe = (Farbe)auswahlHaarfarbe.getSelectedItem();
				var augenfarbe = (Farbe)auswahlAugenfarbe.getSelectedItem();
				var beruf = berufFeld.getText();
				var nationalitaet = nationalitaetFeld.getText();
				
				if (name == null || geschlecht == null || haarfarbe == null || augenfarbe == null || beruf == "" || nationalitaet == "") {
					warnungFeld.setText("Nicht genug Felder wurden ausgefüllt.");
				}
				else {
					feldName.setText("");
					auswahlGeschlecht.setSelectedIndex(0);
					auswahlHaarfarbe.setSelectedIndex(0);
					auswahlAugenfarbe.setSelectedIndex(0);
					berufFeld.setText("");
					nationalitaetFeld.setText("");
					
					var daten = new Daten(name, alter, geschlecht, haarfarbe, augenfarbe, beruf, nationalitaet);
					var speicher = new Speicher("formular.daten");
					var array = speicher.laden();
					if (array == null) {
						array = new ArrayList<Daten>();
					}
					for (var angestellt : array) {
						
					}
					array.add(daten);
					speicher.speichern(array);
				}
			}
		});
		btnSpeichern.setBounds(26, 367, 105, 27);
		frame.getContentPane().add(btnSpeichern);
	}
}
