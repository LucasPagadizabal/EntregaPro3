package Ordenamiento;
public class Lista {
	
	int [] arrAux;
	int[] arr;
	int cont;
	public Lista(int val) {
		arr = new int[val];
		cont = 0;
	}
	
	public int length(){
		return arr.length;
	}
	
	public int size(){
		return cont;
	}
	public void add(int val){
		if(cont < arr.length){
			arr[cont] = val;
			cont++;
		}
	}
	
	public Integer at(int pos){
		if(pos < cont){
			return arr[pos];
		}else{
			return null;
		}
	}
	
	public void ordenarBurbujeo (){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]){
					int tmp = arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
		}
	}
	
	public void ordenarMergeSort(){
		
		arrAux = new int[arr.length];
		mergesort(0,arr.length-1);
	}
	
	public void mergesort(int min, int max){
		
		if(min < max){//si esta condicion no se cumple es porque el arr no se puede dividir mas
			
			int medio = (min + max)/2;
			
			mergesort(min,medio);
			
			mergesort(medio+1,max);
			
			merge(min,medio,max);
		}
	}
	
	public void merge(int min,int medio, int max){
		
		for (int i = 0; i < arrAux.length; i++) {
			arrAux[i]= arr[i];
		}
		
		int i = min;//indice para recorrer el 1er arr
		int j = medio + 1;//indice para recorrer el 2do arr
		int k = min;//controlar que no se pase del arreglo gral
		
		while(i <= medio && j <= max){
			if(arrAux[i] < arrAux[j]){//comparar las dos partes
				arr[k] = arrAux[i];
				i++;
			}else{
				arr[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i <= medio){//paso los que qdaron en en el arreglo aux que ya estan ordenados
			arr[k] = arrAux[i];
			k++;
			i++;
		}
	}
	
	
}
