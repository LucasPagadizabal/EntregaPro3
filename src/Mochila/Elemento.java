package Mochila;

public class Elemento {
	
	double valor;
	double peso;
	double cant;
	String nombre;
	
	public double getCant() {
		return cant;
	}

	public void setCant(double cant) {
		this.cant = cant;
	}

	public Elemento(String s,double val, double p, double c){
		valor = val;
		peso = p;
		cant = c;
		nombre = s;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getRelacion(){
		return valor/peso;
	}
	
	@Override
	public String toString() {
		return "***************\n"+"Nombre: "+this.getNombre()+"\n"+"Valor: "+this.getValor()+"\n"+"Peso: "+this.getPeso()+"\n"+"Cantidad: "+this.getCant();
		
		
	}
}
