package IHC;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Personagem {

	private int x;
	private int y; 
	private int dx, dy;
	private int largura, altura;
	private Image imagem;

	Pedras in = new Pedras(x, y);

	public Personagem() {

		ImageIcon img = new ImageIcon("img\\fantasma.png");
		imagem = img.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		this.x = 200;
		this.y = 200;

	}

	public void mexer() {
		x += dx;
		y += dy;

		if (this.x < -3) {
			x = -3;
		}
		if (this.y < 1) {
			y = 1;
		}
		if (this.y > 493) {
			y = 493;
		}
	}

	public void keyPressed(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_SPACE) {
			dy = -5;
		}
	}

	public void keyReleased(KeyEvent tecla) {
		dy = 3;
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public int getDx() {
		return dx;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

}
