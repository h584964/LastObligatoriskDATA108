package no.hvl.hjelpeklasser;

import javax.persistence.Embeddable;

@Embeddable
public class Passord {
	private String pwd_hash;
    private String pwd_salt;
    
	private Passord(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	public Passord() {}
	
	public String getPwd_hash() {
		return pwd_hash;
	}
	
	public String getPwd_salt() {
		return pwd_salt;
	}

	@Override
	public String toString() {
		return "Passord [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
	}

	public static Passord lagPassord(String passord) {
		String salt = PassordUtil.genererTilfeldigSalt();
		String hash = PassordUtil.hashMedSalt(passord, salt);
		return new Passord(hash, salt);
	}

	
}
