package org.java.obj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	private LocalDate data;
	private int nPosti;
	private int nPostiPrenotati;
	
	public Evento(String titolo, LocalDate data, int nPosti) throws Exception {
		
		setTitolo(titolo);
		setData(data);
		setnPosti(nPosti);
		setnPostiPrenotati(0);
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) throws Exception {
		
		this.data = data;
	}
	public int getnPosti() {
		return nPosti;
	}
	private void setnPosti(int nPosti) throws Exception {
		
		if (nPosti <= 0) throw new Exception("Numero posti " + nPosti + " non valido");
		
		this.nPosti = nPosti;
	}
	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}
	private void setnPostiPrenotati(int nPostiPrenotati) {
		this.nPostiPrenotati = nPostiPrenotati;
	}
	
	public void prenota() throws Exception {
		
		if (getData().isBefore(LocalDate.now())) throw new Exception("Impossibile prenotare evento nel passato");
		
		prenota(1);
	}
	public void prenota(int np) throws Exception {
		
		if (np <= 0 || nPosti < nPostiPrenotati + np) throw new Exception("Nessun posto disponibile");
		
		nPostiPrenotati += np;
	}
	public void disdici() throws Exception {
		
		disdici(1);
	}
	public void disdici(int np) throws Exception {
		
		if (np <= 0 || nPostiPrenotati - np < 0) throw new Exception("Non ci sono abbastanza posti da prenotare");
		
		nPostiPrenotati -= np;
	}
	public String getHumanDate() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		return formatter.format(getData());
	}
	@Override
	public String toString() {
		
		return getHumanDate() + " - " + getTitolo();
	}
}
