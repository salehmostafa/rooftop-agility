package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.City;

import javax.swing.JButton;

public class GUI {
	private JFrame myFrame;
	private JPanel contentPane;
	private JComboBox<City> comboBox;
	
	private boolean started = false;
	
	public GUI() {
		myFrame = new JFrame("Cape's Rooftop Agility");
		myFrame.setBounds(100, 100, 250, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		myFrame.setContentPane(contentPane);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(16, 20, 218, 29);
		comboBox.setModel(new DefaultComboBoxModel<>(City.values()));
		contentPane.setLayout(null);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setBounds(13, 65, 223, 29);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myFrame.setVisible(false);
				myFrame.dispose();
				started = true;
			}
		});
		contentPane.add(btnNewButton);
		myFrame.setVisible(true);
	}
	
	public boolean getStarted() {
		return started;
	}
	
	public City getCity() {
		return (City)comboBox.getSelectedItem();
	}
}
