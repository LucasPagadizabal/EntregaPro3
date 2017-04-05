package Ordenamiento;
public class Main {

	public static void main(String[] args) {
		
		Lista l1 = new Lista(15000);
		
		//agregar datos random
		for (int i = 0; i < l1.length(); i++) {
			l1.add((int)(Math.random() * 10000));
		}
		
//		long time_start, time_end;
//		time_start = System.currentTimeMillis();
//		l1.ordenarBurbujeo(); // llamamos a la tarea
//		time_end = System.currentTimeMillis();
//		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
//		
		//El metodo de ordenamiento por burbujeo es de 1891 milisegundos, tiene una complejidad de n², ya que recorre y compara n elementos
		
		
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		l1.ordenarMergeSort(); // llamamos a la tarea
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		
		//El metodo de ordenamiento por burbujeo es de 482 milisegundos, tiene una complejidad O(n log n), comparado con el de burbujeo,
		//es mas rapido, ya que siempre se comparan entre dos elementos y no un elemento con todo el arreglo
		
				
		//imprimir
		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.at(i));
		}
	}

}
