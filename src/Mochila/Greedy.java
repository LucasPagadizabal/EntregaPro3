package Mochila;

public class Greedy {

	public Elemento[] greedy(Elemento[] e,int pesoMax){
	
		this.burbujeo(e);//ordenar segun relacion
		
		Elemento[] mochila = new Elemento[e.length];
		
		for (int i = 0; i < mochila.length; i++) {
			mochila[i] = new Elemento(e[i].getNombre(), e[i].getValor(),e[i].getPeso(), 0);
		}
		
		int peso = 0;
		int indice = 0;
					
		while(peso < pesoMax && indice < e.length){
			
			if(e[indice].getPeso() <= pesoMax - peso && e[indice].getCant()>0){
				mochila[indice].setCant(mochila[indice].getCant()+1);
				peso+= e[indice].getPeso();
				e[indice].setCant(e[indice].getCant()-1);
			}else{
				indice++;
			}
			
		}
		return mochila;
	}

	public void burbujeo(Elemento [] e){
		for (int i = 0; i < e.length; i++) {
			for (int j = i+1; j < e.length; j++) {
				if(e[i].getRelacion() <= e[j].getRelacion()){
					Elemento tmp = e[j];
					e[j]=e[i];
					e[i]=tmp;
				}

			}

		}

	}
}
