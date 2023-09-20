package RechnerGui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Window {

	private JFrame frame;
	
	private Float zahl1;
	private Float zahl2;
	private String operation;
	
	JLabel labelErgebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}
	private void setErgebnis(String n) {
		if (operation == null) {
			operation="";
			labelErgebnis.setText("");
		}
		labelErgebnis.setText(labelErgebnis.getText() + n);
	}
	private void operationMachen(String operation) {
		if (zahl1 == null) {
			zahl1 = Float.parseFloat(labelErgebnis.getText());
			this.operation = operation;
			labelErgebnis.setText("");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		labelErgebnis = new JLabel("0");
		labelErgebnis.setBounds(39, 50, 347, 17);
		frame.getContentPane().add(labelErgebnis);
		
		JButton button1 = new JButton("1");
		button1.setBounds(39, 83, 41, 27);
		frame.getContentPane().add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("1");
			}
		});
		
		JButton button2 = new JButton("2");
		button2.setBounds(101, 83, 41, 27);
		frame.getContentPane().add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("2");
			}
		});
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.setBounds(247, 83, 41, 27);
		frame.getContentPane().add(buttonPlus);
		buttonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operationMachen("+");
			}
		});
		
		JButton buttonErgebnis = new JButton("=");
		buttonErgebnis.setBounds(164, 199, 41, 27);
		frame.getContentPane().add(buttonErgebnis);
		
		JButton button3 = new JButton("3");
		button3.setBounds(164, 83, 41, 27);
		frame.getContentPane().add(button3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("3");
			}
		});
		
		JButton button4 = new JButton("4");
		button4.setBounds(39, 121, 41, 27);
		frame.getContentPane().add(button4);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("4");
			}
		});
		
		JButton button5 = new JButton("5");
		button5.setBounds(101, 121, 41, 27);
		frame.getContentPane().add(button5);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("5");
			}
		});
		
		JButton button6 = new JButton("6");
		button6.setBounds(164, 121, 41, 27);
		frame.getContentPane().add(button6);
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("6");
			}
		});
		
		JButton button7 = new JButton("7");
		button7.setBounds(39, 160, 41, 27);
		frame.getContentPane().add(button7);
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("7");
			}
		});
		
		JButton button8 = new JButton("8");
		button8.setBounds(101, 160, 41, 27);
		frame.getContentPane().add(button8);
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("8");
			}
		});
		
		JButton button9 = new JButton("9");
		button9.setBounds(164, 160, 41, 27);
		frame.getContentPane().add(button9);
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("9");
			}
		});
		
		JButton button0 = new JButton("0");
		button0.setBounds(101, 199, 41, 27);
		frame.getContentPane().add(button0);
		
		JButton buttonMinus = new JButton("-");
		buttonMinus.setBounds(247, 121, 41, 27);
		frame.getContentPane().add(buttonMinus);
		buttonMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operationMachen("-");
			}
		});
		
		JButton buttonMal = new JButton("*");
		buttonMal.setBounds(247, 160, 41, 27);
		frame.getContentPane().add(buttonMal);
		buttonMal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operationMachen("*");
			}
		});
		
		JButton buttonGeteilt = new JButton("/");
		buttonGeteilt.setBounds(247, 199, 41, 27);
		frame.getContentPane().add(buttonGeteilt);
		
		JButton buttonKomma = new JButton(",");
		buttonKomma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (labelErgebnis.getText() != "") {
					labelErgebnis.setText(labelErgebnis.getText() + ".");
				}
			}
		});
		buttonKomma.setBounds(39, 199, 41, 27);
		frame.getContentPane().add(buttonKomma);
		buttonGeteilt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operationMachen("/");
			}
		});
		
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setErgebnis("0");
			}
		});
		
		buttonErgebnis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (labelErgebnis.getText() != "" && operation != "" && zahl1 != null) {
					zahl2 = Float.parseFloat(labelErgebnis.getText());
				}
				
				Float ergebnis;
				if (zahl2 != null) {
					switch (operation) {
					case "+":
						ergebnis = zahl1 + zahl2;
						labelErgebnis.setText(ergebnis.toString());
						zahl1 = null;
						zahl2 = null;
						break;
					case "-":
						ergebnis = zahl1 - zahl2;
						labelErgebnis.setText(ergebnis.toString());
						zahl1 = null;
						zahl2 = null;
						break;
					case "*":
						ergebnis = zahl1 * zahl2;
						labelErgebnis.setText(ergebnis.toString());
						zahl1 = null;
						zahl2 = null;
						break;
					case "/":
						ergebnis = zahl1 / zahl2;
						labelErgebnis.setText(ergebnis.toString());
						zahl1 = null;
						zahl2 = null;
						break;
					}
				}
			}
		});
	}
}
