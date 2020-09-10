package IHC;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pedras {
	private static final int LARGURA_TELA = 1299;
	private static final int VELOCIDADE = 2;
	private int x,y;
	private int largura, altura;
	private Image img;
	boolean isVisivel=true;
	int contador;
	public Pedras(int startX,int startY ){
		
		this.x=startX;
		this.y=startY;
		
		
		
		ImageIcon imagem = new ImageIcon("img\\pedra1.png");
		img = imagem.getImage();
		
		this.largura = img.getWidth(null);
		this.altura = img.getHeight(null);
		
		
	}
	public boolean Visivel() 
	{
		return isVisivel;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImg() {
		return img;
	}
	public void mover(){

		if(this.x < 0){
			this.x = LARGURA_TELA;	
		} else {
			this.x -= VELOCIDADE;
		}
	}
	public void naomover(){

		if(this.x < 0){
			this.x = 0;	
		} else {
			this.x -= 0;
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle (x, y, largura, altura);
	}
}
