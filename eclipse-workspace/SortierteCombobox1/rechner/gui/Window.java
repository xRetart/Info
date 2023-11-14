package rechner.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.BorderLayout;

public class Window {
	private JFrame frame;
	private JTextField textField;
	private JButton btnHerausnehmen;
	
	private Vector<String> inventar = new Vector<>();
	
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
		frame.setBounds(100, 100, 416, 98);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		var comboBox = new JComboBox<>(inventar);
		
		frame.getContentPane().add(comboBox, BorderLayout.NORTH);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnHinzufgen = new JButton("Hinzufügen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var text = textField.getText();
				inventar.add(text);
				Collections.sort(inventar);
				comboBox.setSelectedItem(text);
				textField.setText("");
			}
		});
		frame.getContentPane().add(btnHinzufgen, BorderLayout.EAST);
		
		btnHerausnehmen = new JButton("Herausnehmen");
		btnHerausnehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inventar.isEmpty()) {
					inventar.remove(comboBox.getSelectedIndex());
				}
				
				if (!inventar.isEmpty()) {
					comboBox.setSelectedIndex(0);
				}
				else {
					comboBox.setSelectedItem(null);
				}
			}
		});
		frame.getContentPane().add(btnHerausnehmen, BorderLayout.WEST);
	}
}
