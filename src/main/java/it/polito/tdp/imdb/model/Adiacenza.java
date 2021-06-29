package it.polito.tdp.imdb.model;

public class Adiacenza {

	Director d1;
	Director d2;
	int peso;
	public Adiacenza(Director d1, Director d2, int peso) {
		super();
		this.d1 = d1;
		this.d2 = d2;
		this.peso = peso;
	}
	public final Director getD1() {
		return d1;
	}
	public final void setD1(Director d1) {
		this.d1 = d1;
	}
	public final Director getD2() {
		return d2;
	}
	public final void setD2(Director d2) {
		this.d2 = d2;
	}
	public final int getPeso() {
		return peso;
	}
	public final void setPeso(int peso) {
		this.peso = peso;
	}
	
	
}
