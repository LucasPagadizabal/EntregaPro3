package DFS;

public class Vertice {
	
	int indice;
	EstadoVertice  estado;
	int inicio;
	int fin;
	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public Vertice(int i, EstadoVertice s) {
		indice = i;
		estado = s;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public EstadoVertice getEstado() {
		return estado;
	}

	public void setEstado(EstadoVertice estado) {
		this.estado = estado;
	}
	
	

}
