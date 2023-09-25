package rechner.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Window {

	private JFrame frame;
	private JLabel labelZahl;
	
	private Double zahl1;
	private Double zahl2;
	private Character operation;
	
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
	
	private void zifferHinzufuegen(Character zahl) {
		final var zahlText = labelZahl.getText();
		if (zahlText.contentEquals("0")) {
			labelZahl.setText(zahl.toString());
		}
		else {
			labelZahl.setText(zahlText + zahl);
		}
	}
	private void rechnen(Character operation) {
		if (this.operation == null) {
			this.operation = operation;
			zahl1 = Double.parseDouble(labelZahl.getText());
			labelZahl.setText("");
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		labelZahl = new JLabel("0");
		labelZahl.setBounds(39, 50, 347, 17);
		frame.getContentPane().add(labelZahl);
		
		// Ziffern-Buttons
		final var button1 = new JButton("1");
		frame.getContentPane().add(button1);
		button1.setBounds(39, 83, 41, 27);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('1');
			}
		});
		final var button2 = new JButton("2");
		frame.getContentPane().add(button2);
		button2.setBounds(101, 83, 41, 27);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('2');
			}
		});
		final var button3 = new JButton("3");
		frame.getContentPane().add(button3);
		button3.setBounds(164, 83, 41, 27);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('3');
			}
		});
		final var button4 = new JButton("4");
		frame.getContentPane().add(button4);
		button4.setBounds(39, 121, 41, 27);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('4');
			}
		});
		final var button5 = new JButton("5");
		frame.getContentPane().add(button5);
		button5.setBounds(101, 121, 41, 27);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('5');
			}
		});
		final var button6 = new JButton("6");
		frame.getContentPane().add(button6);
		button6.setBounds(164, 121, 41, 27);
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('6');
			}
		});
		final var button7 = new JButton("7");
		frame.getContentPane().add(button7);
		button7.setBounds(39, 160, 41, 27);
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('7');
			}
		});
		final var button8 = new JButton("8");
		frame.getContentPane().add(button8);
		button8.setBounds(101, 160, 41, 27);
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('8');
			}
		});
		final var button9 = new JButton("9");
		frame.getContentPane().add(button9);
		button9.setBounds(164, 160, 41, 27);
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('9');
			}
		});
		final var button0 = new JButton("0");
		frame.getContentPane().add(button0);
		button0.setBounds(101, 199, 41, 27);
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zifferHinzufuegen('0');
			}
		});

		// Rechenzeichen-Buttons
		final var buttonPlus = new JButton("+");
		frame.getContentPane().add(buttonPlus);
		buttonPlus.setBounds(247, 83, 41, 27);
		buttonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechnen('+');
			}
		});

		final var buttonMinus = new JButton("-");
		frame.getContentPane().add(buttonMinus);
		buttonMinus.setBounds(247, 121, 41, 27);
		buttonMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechnen('-');
			}
		});
		final var buttonMal = new JButton("*");
		frame.getContentPane().add(buttonMal);
		buttonMal.setBounds(247, 160, 41, 27);
		buttonMal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechnen('*');
			}
		});
		final var buttonGeteilt = new JButton("/");
		frame.getContentPane().add(buttonGeteilt);
		buttonGeteilt.setBounds(247, 199, 41, 27);
		buttonGeteilt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechnen('/');
			}
		});
		
		// Komma
		final var buttonKomma = new JButton(",");
		frame.getContentPane().add(buttonKomma);
		buttonKomma.setBounds(39, 199, 41, 27);
		buttonKomma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var text = labelZahl.getText();
				if (!text.isEmpty() && !text.contains(".")){
					labelZahl.setText(labelZahl.getText() + ".");
				}
			}
		});

		// Gleich
		final var buttonErgebnis = new JButton("=");
		frame.getContentPane().add(buttonErgebnis);
		buttonErgebnis.setBounds(164, 199, 41, 27);
		
		JButton buttonClear = new JButton("clear");
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation = null;
				zahl1 = null;
				zahl2 = null;
				labelZahl.setText("");
			}
		});
		buttonClear.setBounds(307, 160, 79, 27);
		frame.getContentPane().add(buttonClear);
		
		JButton buttonPotenz = new JButton("^");
		buttonPotenz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechnen('^');
			}
		});
		buttonPotenz.setBounds(307, 199, 41, 27);
		frame.getContentPane().add(buttonPotenz);
		
		JButton buttonWurzel = new JButton("√");
		buttonWurzel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechnen('s');
			}
		});
		buttonWurzel.setBounds(307, 121, 41, 27);
		frame.getContentPane().add(buttonWurzel);
		buttonErgebnis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final var labelText = labelZahl.getText();
				if (!labelText.isEmpty() && operation != null && zahl1 != null) {
					zahl2 = Double.parseDouble(labelText);
					
					var ergebnis = zahl1;
					switch (operation) {
					case '+': ergebnis += zahl2; break;
					case '-': ergebnis -= zahl2; break;
					case '*': ergebnis *= zahl2; break;
					case '/': ergebnis /= zahl2; break;
					case '^': ergebnis = Math.pow(ergebnis, zahl2); break;
					case 's': ergebnis = Math.pow(ergebnis, 1 / zahl2); break;
					}
					
					labelZahl.setText(ergebnis.toString());
					
					zahl1 = null;
					zahl2 = null;
					operation = null;
				}
			}
		});
	}
}
