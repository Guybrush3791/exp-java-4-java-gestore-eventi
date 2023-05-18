package org.java.obj;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	LocalTime ora;
	BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int nPosti,
					LocalTime ora, BigDecimal prezzo) throws Exception {
		
		super(titolo, data, nPosti);
		
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	public String getHumanTime() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return formatter.format(getOra());
	}
	public String getHumanPrice() {
		
		DecimalFormat df = new DecimalFormat("##.00");
		
		String res = df.format(getPrezzo()); 
		if (res.contains("."))
			res = res.replace('.', ',');
		
		return res + "€";
	}
	public String getHumanDateTime() {
		
		return getHumanDate() + " - " + getHumanTime();
	}
	
	@Override
	public String toString() {
		
		return getHumanDateTime() + " - " + getTitolo() + " - " + getHumanPrice();
	}
}
