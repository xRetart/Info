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
import java.awt.GridLayout;
import javax.swing.JPanel;

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
		frame.setBounds(100, 100, 416, 227);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCharakter = new JLabel("Charakter:");
		lblCharakter.setBounds(37, 12, 106, 26);
		frame.getContentPane().add(lblCharakter);
		
		JLabel lblCharakterStatus = new JLabel("Richard Jeremias Leonhard Hildebrandt");
		lblCharakterStatus.setBounds(148, 17, 246, 17);
		frame.getContentPane().add(lblCharakterStatus);
		
		JLabel lblLebenspunkte = new JLabel("Lebenspunkte:");
		lblLebenspunkte.setBounds(37, 57, 106, 17);
		frame.getContentPane().add(lblLebenspunkte);
		
		JLabel lblLebenspunkteStatus = new JLabel("100/100");
		lblLebenspunkteStatus.setBounds(148, 57, 226, 17);
		frame.getContentPane().add(lblLebenspunkteStatus);
		
		JButton btnInventar = new JButton("Inventar");
		btnInventar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var frame = new Inventar();
				frame.setVisible(true);
			}
		});
		btnInventar.setBounds(37, 119, 105, 27);
		frame.getContentPane().add(btnInventar);
		
		
	}
}
