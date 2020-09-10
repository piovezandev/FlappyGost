package IHC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import sun.audio.*; 	              	

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.spi.AudioFileReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
	private int contador = 0;
	private Image imagemfundo;
	private Timer timerTela;
	private Personagem fantasminha;
	private List<Pedras> pedras;
	private boolean jogando=true;

	private int[][] PosicoesPedras = { { 600, 0 }, { 600, 500 }, { 900, -150 },
			{ 900, 330 }, { 1200, -260 }, { 1200, 250 }, { 1500, -100 },
			{ 1500, 400 } };

	public Fase() {

		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		ImageIcon img = new ImageIcon("img\\imagem.jpg");
		imagemfundo = img.getImage();
		fantasminha = new Personagem();


		timerTela = new Timer(10, this);
		timerTela.start();
		
		inicializaPedras();

		checarColisoes();

	}

	public void inicializaPedras() {
		pedras = new ArrayList<Pedras>();

		for (int i = 0; i < PosicoesPedras.length; i++) {
			pedras.add(new Pedras(PosicoesPedras[i][0], PosicoesPedras[i][1]));

		}
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(imagemfundo, 0, 0, null);

		Font font = new Font("Dialog", Font.BOLD, 25);

		graficos.setFont(font);
		graficos.setColor(Color.RED);


		if (jogando == true) {
 
	
			graficos.drawImage(fantasminha.getImagem(), fantasminha.getX(),
					fantasminha.getY(), this);

			for (int i = 0; i < pedras.size(); i++) {
				Pedras in = pedras.get(i);
				graficos.drawImage(in.getImg(), in.getX(), in.getY(), this);
				contador += 1;

			}
			graficos.drawString("Percorreu: " + contador/1000 + " KM", 500,
					20);
			
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImageIcon fimJogo = new ImageIcon("img\\gameover.jpg");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			graficos.drawString("Parabens Voce Percorreu:" + contador / 1000
					+ " KM", 500, 20);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		fantasminha.mexer();

		for (int i = 0; i < pedras.size(); i++) {
			Pedras in = pedras.get(i);

			if (in.isVisivel) {
				in.mover();

			} else {
         pedras.remove(i);
				}
		}
		checarColisoes();
		 repaint();

	}

	public void checarColisoes() {

		Rectangle formaFantasma = fantasminha.getBounds();
		Rectangle formaPedra;

		for (int i = 0; i < pedras.size(); i++) {
			Pedras tempInimigo = pedras.get(i);
			formaPedra = tempInimigo.getBounds();

			if (formaFantasma.intersects(formaPedra)) {
				jogando = false;

			}
		}

	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode()== KeyEvent.VK_ENTER){
				jogando=true;
				fantasminha = new Personagem();
				contador=0;
				inicializaPedras();
			}if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
				System.exit(0);
			}
			
			fantasminha.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			fantasminha.keyReleased(e);
		}

	}

}
