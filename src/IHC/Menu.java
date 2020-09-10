package IHC;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;
   
	public Menu() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		new Tela();
			}
		});
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\alan\\Pictures\\images PNG\\testeplay.png"));
		btnNewButton.setBounds(259, 317, 107, 49);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\alan\\Pictures\\images PNG\\menu.png"));
		lblNewLabel.setBounds(0, 11, 584, 449);
		contentPane.add(lblNewLabel);
	   setResizable(false);
		setVisible(true);
	}
}
