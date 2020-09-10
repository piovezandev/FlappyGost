package Teste;


import IHC.Menu;
import IHC.Menu;


public class Main implements Runnable{
	
	public static void main(String[] args) {
		
	Main m = new Main();
	
	new Thread(m).start();
		
	}
	@Override
	public void run() {
		new Menu();		
	}

}