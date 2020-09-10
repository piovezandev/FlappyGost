package IHC;

import javax.swing.JFrame;

public class Tela extends JFrame {

	public Tela() {

		add(new Fase());
		setTitle("Flapy Ghosts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1299, 581);
		setLocationRelativeTo(null);
		setVisible(true);
        setResizable(false);
	}

}
