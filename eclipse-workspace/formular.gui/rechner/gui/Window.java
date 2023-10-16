package rechner.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Window {
	private JFrame frame;
	
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
		frame.setBounds(100, 100, 416, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox<Person> comboBox = new JComboBox<Person>();
		comboBox.setModel(new DefaultComboBoxModel(Person.values()));
		comboBox.setBounds(49, 83, 125, 26);
		frame.getContentPane().add(comboBox);
		
		JLabel label = new JLabel("");
		label.setBounds(49, 12, 330, 59);
		frame.getContentPane().add(label);
		
		JButton btnAuswhlen = new JButton("Fun Fact!");
		btnAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person item = (Person) comboBox.getSelectedItem();
				switch (item) {
				case Asien: label.setText("Sie wohnen auf dem größten Kontinent!"); break;
				case Ozeanien: label.setText("Sie wohnen auf dem kleinsten Kontinent!"); break;
				case Europa: label.setText("Sie wohnen auf dem friedlichsten Kontinent!"); break;
				case Antarktis: label.setText("Sie wohnen auf dem kältesten Kontinent!"); break;
				case Afrika: label.setText("Sie wohnen auf dem ressoursen-reichsten Kontinent!"); break;
				case Nordamerika: label.setText("Sie wohnen auf dem Kontinent mit der größten Insel!"); break;
				case Suedamerika: label.setText("Sie wohnen auf dem höchsten Kontinent!"); break;
				}
			}
		});
		btnAuswhlen.setBounds(49, 121, 105, 27);
		frame.getContentPane().add(btnAuswhlen);
	}
}
