package DFS;

public class Main {

	public static void main(String[] args) {

		GrafoDirigido g = new GrafoDirigido(4000);// el contructor recibe la cantidad de vertices inicial

		for (int i = 0; i < 4000; i++) {
			g.addVertice(i);
		}
		
		g.addAristas();


//		for (int i = 0; i < g.getCantVertices(); i++) {
//			for (int j = 0; j < g.getCantAristasByVert(i); j++) {
//				System.out.println("Vertice: "+i+" Arista: " +g.getValorArista(i, j));
//			}
//		}
		
		System.out.println("Hay ciclo: " +g.tieneCicloRecursivo());
		System.out.println("Hay ciclo: " +g.tieneCicloIterativo());

		g.addArista(555, 5); //agregar arco para que sea ciclico
		
		System.out.println("Hay ciclo: " +g.tieneCicloRecursivo());
		System.out.println("Hay ciclo: " +g.tieneCicloIterativo());

		//En el metodo recursivo con esta cantidad de vertices (4000) sigue siendo eficaz referido al tiempo, pero ocupa mas memoria
		//pasando los 4000 de vertices sin tener un arco recursivo tira StackOverflow
		//en cambio al Iterativo tarda mucho mas, pero ocupa menos memoria
	}

}
