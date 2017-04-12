package DFS;

public class GrafoDirigido {

	static Lista[] vertices;


	public GrafoDirigido(int ver){
		vertices = new Lista[ver];
	}

	public int getCantVertices(){
		return vertices.length;
	}

	public int getCantAristasByVert(int i){
		return vertices[i].size();
	}

	public void addVertice(int indice){

		if(indice >= vertices.length){
			Lista[] aux = new Lista[indice * 2];

			for (int i = 0; i < aux.length; i++) {
				aux[i] = vertices[i];
				aux[i] = new Lista();
				vertices = aux;
			}
		}
		vertices[indice] = new Lista();

	}

	public void addArista(int i, int j){
		if(i < vertices.length && j < vertices.length){
			vertices[i].addNodo(j);;
		}
	}

	public int getValorArista(int v,int i){
		return vertices[v].at(i);
	}

	public static boolean tieneCicloRecursivo(){
		Vertice[] aux = new Vertice [vertices.length];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new Vertice(i,EstadoVertice.NoVisitado);
		}
		//cargado
		int tiempo = 0;

		for (int j = 0; j < aux.length; j++) {
			if(aux[j].getEstado() == EstadoVertice.NoVisitado){
				return DFS_Visit(aux[j],tiempo,aux);
			}
		}
		return false;
	}

	private static boolean DFS_Visit(Vertice v,int t, Vertice[] aux){
		v.setEstado(EstadoVertice.Visitandose);
		v.setInicio(t);
		t=t+1;

		for (int i = 0; i < vertices[v.getIndice()].size(); i++) {//recorro la lista de adyacentes
			int pos = vertices[v.getIndice()].at(i);//tomo la posicion para ir a buscar al arreglo aux
			if(aux[pos].getEstado() == EstadoVertice.NoVisitado){// si es blanco paso al vertice para que tmb recorra sus adyacentes
				return DFS_Visit(aux[pos], t, aux);					
			}else if(aux[pos].getEstado() == EstadoVertice.Visitandose){	
				return true;
			}

		}

		v.setEstado(EstadoVertice.Visitado);
		return false;
	}


	public static boolean tieneCicloIterativo(){

		Pila pila = new Pila();

		Vertice[] aux = new Vertice [vertices.length];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = new Vertice(i,EstadoVertice.NoVisitado);
		}
		//cargado
		int indice = 0;
		//cero es el primero vertice
		while(indice < aux.length){//este while es por si hay un vertice sin estar en el grafo que tiene ciclo
			pila.apilar(indice);
			
			while (!pila.estaVacia()) {
				if(aux[pila.verTope()].getEstado() == EstadoVertice.NoVisitado){//blanco
					aux[pila.verTope()].setEstado(EstadoVertice.Visitandose);//amarillo

					//agregar adyacentes
					if(vertices[pila.verTope()].size()>0){//tiene adyacentes
						for (int i = 0; i < vertices[pila.verTope()].size(); i++) {
							if(aux[vertices[pila.verTope()].at(i)].getEstado() == EstadoVertice.NoVisitado){//si es blanco agrega
								pila.apilar(vertices[pila.verTope()].at(i));
							}else if(aux[vertices[pila.verTope()].at(i)].getEstado() == EstadoVertice.Visitandose){//es amarillo
								return true;
							}

						}
					}else{//no tiene adyacentes
						aux[pila.verTope()].setEstado(EstadoVertice.Visitado);//negro
						pila.desapilar();
					}



				}else if(aux[pila.verTope()].getEstado() == EstadoVertice.Visitado){//negro
					pila.desapilar();
				}else{
					aux[pila.verTope()].setEstado(EstadoVertice.Visitado);//amarillo
					pila.desapilar();
				}

			}
			indice++;
		}
		return false;
	}

	public void addAristas(){
		int i = 0;
		while( i < vertices.length-1){
			this.addArista(i, i+2);
			this.addArista(i, i+1);
			i++;
		}
	}
}
