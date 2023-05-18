package org.java;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.java.obj.Evento;
import org.java.obj.ProgrammEventi;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
//			MILESTONE 1 - 2
//			System.out.print("titolo: ");
//			String titolo = sc.nextLine();
//			
//			System.out.print("numero posti: ");
//			int nPosti = Integer.valueOf(sc.nextLine());
//			
//			System.out.print("data: ");
//			LocalDate data = LocalDate.parse(sc.nextLine());
//			
//			Evento e = new Evento(titolo, data, nPosti);
//			System.out.println(e);
//			
//			System.out.println("Vuoi prenotare dei posti?");
//			System.out.println("1 - si'");
//			System.out.println("2 - no");
//			int res = Integer.valueOf(sc.nextLine());
//			if (res == 1) {
//			
//				System.out.print("posti da prenotare: ");
//				int nPostiPrenotare = Integer.parseInt(sc.nextLine());
//
//				e.prenota(nPostiPrenotare);
//			}
//			System.out.println(e.getnPostiPrenotati() + "/" + e.getnPosti());
//			
//			System.out.println("Vuoi disdire dei posti?");
//			System.out.println("1 - si'");
//			System.out.println("2 - no");
//			res = Integer.valueOf(sc.nextLine());
//			if (res == 1) {
//			
//				System.out.print("posti da disdire: ");
//				int nPostiDisdire = Integer.parseInt(sc.nextLine());
//
//				e.disdici(nPostiDisdire);
//			}
//			System.out.println(e.getnPostiPrenotati() + "/" + e.getnPosti());
			
//			MILESTONE 3
//			Concerto c = new Concerto("mio concerto", LocalDate.now(), 200,
//								LocalTime.now(), new BigDecimal(56.10));
//			System.out.println(c);
			
//			
			ProgrammEventi pe = new ProgrammEventi("Eventi serie");
			pe.addEvento(new Evento("mio evento1", LocalDate.parse("2023-01-01"), 100));
			pe.addEvento(new Evento("mio evento2", LocalDate.parse("2023-10-01"), 200));
			pe.addEvento(new Evento("mio evento3", LocalDate.parse("2023-08-01"), 500));
			pe.addEvento(new Evento("mio evento4", LocalDate.parse("2023-01-01"), 1000));
			
			System.out.println(pe);
			
			List<Evento> eventiPrimoGennaio = pe.getEventiByData(LocalDate.parse("2023-01-01"));
			System.out.println(eventiPrimoGennaio);
			
			int eventiCount = pe.getNumeroEventi();
			System.out.println("numero eventi: " + eventiCount);
			
			pe.clearEventi();
			System.out.println("--clear--");
			
			eventiCount = pe.getNumeroEventi();
			System.out.println("numero eventi: " + eventiCount);
		} catch(Exception e) {
			
			System.err.println("Errore in evento: " + e.getMessage());
		} finally {
			
			sc.close();
		}
	}
}
