package P1;

import java.sql.Date;
import java.util.*;

public class Main{
	public static void main(String[] arg) {
		ReizigerOracleDaolmpl ro1 = new ReizigerOracleDaolmpl();

		
		Reiziger r1 = new Reiziger();
		String geborteString1 = "726793200000"; //01-12-1993
		long geborteDate1 = Long.valueOf(geborteString1);
		java.sql.Date date1 = new java.sql.Date(geborteDate1);
		r1.setNaam("Kevin Groenendijk");
		r1.setGbdatum(date1);
		ro1.save(r1);
		
		Reiziger r2 = new Reiziger();
		String geborteString2 = "788828400000"; //12-31-1994
		long geborteDate2 = Long.valueOf(geborteString2);
		System.out.println(geborteDate2);
		java.sql.Date date2 = new java.sql.Date(geborteDate2);
		r2.setNaam("Jesper Groenendijk");
		r2.setGbdatum(date2);
		ro1.save(r2);
		
		System.out.println("De reizigers: ");
		for (Reiziger reiziger : ro1.findAll()) {
			System.out.println("naam: " +reiziger.getNaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}

		System.out.println("\nDe reizigers na de bewerking: ");
		for (Reiziger reiziger : ro1.findAll()) {
			System.out.println("naam: " +reiziger.getNaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}
	  }
	  
}