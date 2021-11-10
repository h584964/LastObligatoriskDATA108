package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.hjelpeklasser.ValideringForDeltager;



class ValideringTest {

//	ValideringForDeltager riktig;
//	@BeforeEach
//	void setUp(){
//		riktig = new ValideringForDeltager();
//	}
//	
	
	
	@Test
	public void gyldigFornavnFeil() {
		assertFalse(ValideringForDeltager.erGyldigFornavn("johan ludvig"));
	}
	
	@Test
	public void gyldigFornavnRikitg() {
		assertTrue(ValideringForDeltager.erGyldigFornavn("Johan Ludvig"));
	}
	
	@Test
	public void gyldigEtternavnFeil() {
		assertFalse(ValideringForDeltager.erGyldigEtternavn("sørlie"));
	}
	@Test
	public void gyldigEtternavnRikitg() {
		assertTrue(ValideringForDeltager.erGyldigEtternavn("Sørlie"));
	}
	@Test
	public void gyldigMobilFeil() {
		assertFalse(ValideringForDeltager.erGyldigMobil("9943250501"));
	}
	
	@Test
	public void gyldigMobilRiktig() {
		assertTrue(ValideringForDeltager.erGyldigMobil("99432505"));
	}
	
	@Test
	public void gyldigpassordFeil() {
		assertFalse(ValideringForDeltager.erGydligPassord("passo"));
	}
	@Test
	public void gyldigpassordRiktig() {
		assertTrue(ValideringForDeltager.erGydligPassord("A1234567"));
	}
	
	@Test
	public void passordRepetertFeil() {
		assertFalse(ValideringForDeltager.passordRepetert("nE12nd@","dsfhshdfhsdf"));
	}
	
	@Test
	public void passordRepetertRiktig() {
		assertTrue(ValideringForDeltager.passordRepetert("nE12nd", "nE12nd"));
	}
	
	
	
	@Test
	public void gydligKjonnFeil() {
		assertTrue(ValideringForDeltager.erGyldigKjonn("mann"));
	}
	
	
	

}
