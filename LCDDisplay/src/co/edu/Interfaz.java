package co.edu;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Interfaz implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textarea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
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
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Ingrese n");
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese s");
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Dibujar");
		panel_1.add(btnNewButton);
		
		btnNewButton.addActionListener(this);
		
		textarea = new JTextArea();
		textarea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textarea.setEditable(false);
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(textarea);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	 LCDDisplay.Dibujar(textField.getText(),textField_1.getText(),this);
		
		
	}
	
	public void Pintar(String str){
		
		textarea.append(str);
		
		
	}

}
