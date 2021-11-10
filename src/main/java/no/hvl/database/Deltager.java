package no.hvl.database;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import no.hvl.hjelpeklasser.Passord;



@Entity
@Table(schema = "oblig4")
public class Deltager {

	private String fornavn;
	private String etternavn;

	@Id
	private String mobil;

	
	
	@Embedded
	private Passord passord;

	private String kjonn;

	public Deltager() {
		
	}
	

	public Deltager(String fornavn, String etternavn, String mobil, Passord passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}

//	public Deltager(HttpServletRequest request) {
//		// TODO Auto-generated constructor stub
//		fornavn = request.getParameter("fornavn");
//		etternavn = request.getParameter("fornavn");
//		mobil = request.getParameter("fornavn");
//		mobil = request.getParameter("fornavn");
//		passordh = (Passord) request.getAttribute("passordh");
//		kjonn = request.getParameter("kjonn");
//		
//	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public Passord getPassord() {
		return passord;
	}


	public void setPassord(Passord passord) {
		this.passord = passord;
	}


	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}


	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}




}
