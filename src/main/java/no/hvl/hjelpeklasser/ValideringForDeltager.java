package no.hvl.hjelpeklasser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValideringForDeltager {
 /*
  * Her kommer det metoder for validering mot deltager.
  * Hvilken krav som settes 
  * 
  */
	
	public static final String FORNAVN = "[A-ZÆØÅ][A-Za-z -æøå]{2,20}$";
	public static final String ETTERNAVN = "[A-ZÆØÅ][A-Za-z-æøå]{2,20}$"; 
	public static final String MOBIL = "^[0-9]{8}$";
	public static final String PASSORD = "^[0-9][a-z][A-Z]{4,10}$" ;
	
	 
	
	
	
	public static boolean erGyldigFornavn(String fornavn) {
		
		if(fornavn == null) {
			return false;
		}
		
		
		return fornavn.matches(FORNAVN); //regulært utrykk
	}
	
	public static boolean erGyldigEtternavn(String etternavn) {
		
		if(etternavn == null) {
			return false;
		}
		
		
		return etternavn.matches(ETTERNAVN); //regulært utrykk
		
	}
	
	public static boolean erGyldigMobil(String mobil) {
		if(mobil == null) {
			return false;
		}
		
		return mobil.matches(MOBIL); //Nummer med med kunn 8 tall, mer enn det er feil
	}
	
	public static boolean erGydligPassord(String passord) {
		
		if(passord == null) {
			return false;
		}
		
		return passord.matches("^[a-zA-Z0-9_-]{8,20}+$");
	}
	
	public static boolean passordRepetert(String passord, String passordRe) {
		
		System.out.println(passord + " " + passordRe);
		
		
		if (passord == null) {
			return false;
		}

		return passord.equals(passordRe);
		
	}
	
	 public static boolean erGyldigKjonn(String kjonn) {
	        return kjonn != null 
	        		&& (kjonn.equals("mann") || kjonn.equals("kvinne"));
	    }
	 
	 
	 
	

	
}
