package no.hvl.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;

import no.hvl.database.Deltager;
import no.hvl.database.DeltagerDAO;

public class Paameldingsskjema {

	private String fornavn;
	private String feilFornavn;

	private String etternavn;
	private String feilEtternavn;

	private String mobil;
	private String feilMobil;

	private String passord;
	private String feilPassord;

	private String passordRe; // passord repetert
	private String feilPassordRe; // feil passord repetert

	private String kjonn;
	private String feilKjonn; // oppgi kjønn

	private boolean alleGyldig = true;

	public Paameldingsskjema(HttpServletRequest request) {

		this.fornavn = request.getParameter("fornavn");

		this.etternavn = request.getParameter("etternavn");

		this.mobil = request.getParameter("mobil");

		this.passord = request.getParameter("passord");

		this.passordRe = request.getParameter("passordRe");

		this.kjonn = request.getParameter("kjonn");

	}
	
	public Paameldingsskjema() {
		
	}
	
	public boolean gyldigInnput() {
		return ValideringForDeltager.erGyldigFornavn(fornavn) && ValideringForDeltager.erGyldigEtternavn(etternavn) && ValideringForDeltager.erGyldigMobil(mobil) &&
				ValideringForDeltager.erGydligPassord(passord) && ValideringForDeltager.passordRepetert(passord, passordRe) && ValideringForDeltager.erGyldigKjonn(kjonn);
	}
	
	

	
//	public boolean gyldigKjonn(String kjonn) {
//		return kjonn != null 
//        		&& (kjonn.equals("mann") || kjonn.equals("kvinne"));
//	}
	
	public Deltager lagdeltager() {
		
		Passord passordhash = Passord.lagPassord(passord);
		return new Deltager(fornavn, etternavn, mobil, passordhash, kjonn);
	}
	
	

	public void feilMeldinger() {
		if (!ValideringForDeltager.erGyldigFornavn(fornavn)) {
			fornavn = "";
			feilFornavn = "Ugyldig fornavn";
		}
		
		if (!ValideringForDeltager.erGyldigEtternavn(etternavn)) {
			etternavn = "";
			feilEtternavn = "Ugyldig etternavn";
		}
		
		if (!ValideringForDeltager.erGyldigMobil(mobil)) {
			mobil = "";
			feilMobil = "Ugyldig mobilnummer";
		}
		
		if (!ValideringForDeltager.erGydligPassord(passord)) {
			passord = "";
			feilPassord = "Ugyldig passord";
		}
		
		
		if (!ValideringForDeltager.passordRepetert(passord, passordRe)) {
			passordRe = "";
			feilPassordRe = "Passordene må være like";
		}
		
		if (!ValideringForDeltager.erGyldigKjonn(kjonn)) {
			kjonn = "";
			feilKjonn = "Ugyldig kjonn";
		}
		
//		alleGyldig = gyldigFornavn && gyldigEtternavn && gyldigMobil 
//				&& gyldigPassord && gyldigPassordRe && gyldigKjonn;
	}
	
	
	
	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getFeilFornavn() {
		return feilFornavn;
	}

	public void setFeilFornavn(String feilFornavn) {
		this.feilFornavn = feilFornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getFeilEtternavn() {
		return feilEtternavn;
	}

	public void setFeilEtternavn(String feilEtternavn) {
		this.feilEtternavn = feilEtternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFeilMobil() {
		return feilMobil;
	}

	public void setFeilMobil(String feilMobil) {
		this.feilMobil = feilMobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getFeilPassord() {
		return feilPassord;
	}

	public void setFeilPassord(String feilPassord) {
		this.feilPassord = feilPassord;
	}

	public String getPassordRe() {
		return passordRe;
	}

	public void setPassordRe(String passordRe) {
		this.passordRe = passordRe;
	}

	public String getFeilPassordRe() {
		return feilPassordRe;
	}

	public void setFeilPassordRe(String feilPassordRe) {
		this.feilPassordRe = feilPassordRe;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getFeilKjonn() {
		return feilKjonn;
	}

	public void setFeilKjonn(String feilKjonn) {
		this.feilKjonn = feilKjonn;
	}
	
	public boolean isAlleGyldig() {
		return alleGyldig;
	}

	public void setAlleGyldig(boolean alleGyldig) {
		this.alleGyldig = alleGyldig;
	}




}
