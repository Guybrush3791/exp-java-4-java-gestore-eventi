package org.java.obj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {

	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		
		setTitolo(titolo);
		
		eventi = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public List<Evento> getEventi() {
		return eventi;
	}
	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	public void addEvento(Evento evento) {
		
		eventi.add(evento);
	}
	public List<Evento> getEventiByData(LocalDate data) {
		
		List<Evento> res = new ArrayList<>();		
		for (Evento e : getEventi()) {
			
			if (e.getData().isEqual(data)) {
				
				res.add(e);
			}
		}
		
		return res;
	}
	public int getNumeroEventi() {
		
		return getEventi().size();
	}
	public void clearEventi() {
		
		getEventi().clear();
	}
	@Override
	public String toString() {
		
		String res = getTitolo() + "\n";
		
//		getEventi().sort((e1,e2) -> e1.getData().compareTo(e2.getData()));
		
//		getEventi().sort(Comparator.comparing(e -> e.getData()));
		
		getEventi().sort(new Comparator<Evento>() {

			@Override
			public int compare(Evento o1, Evento o2) {
				
				return (int) (o1.getData().toEpochDay() - o2.getData().toEpochDay());
//				return o1.getData().compareTo(o2.getData());
			}
			
		});
		
		for (Evento e : getEventi()) {
			
			res += e.toString() + "\n";
		}
		
		return res;
	}
}
