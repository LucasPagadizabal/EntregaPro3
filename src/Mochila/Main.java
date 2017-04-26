package Mochila;

public class Main {

	public static void main(String[] args) {
		
		Elemento[] e = new Elemento[4];
		
		
		e[0] = new Elemento("Harina",100,25,10);//4
		e[1] = new Elemento("Yerba",50,5,10);//10	
		e[2] = new Elemento("Lenteja",10,2,3);//5
		e[3] = new Elemento("Cafe",100,1,1);//100
	
		
		Greedy g = new Greedy();
		
		Elemento[] mochila = g.greedy(e,25);//(elementos,pesoMochila) : Elemento[] mochila
		
		for (int i = 0; i < mochila.length; i++) {
			System.out.println(mochila[i].toString());
		}
		
	}

}
