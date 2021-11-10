package no.hvl.database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerDAO {

	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public DeltagerDAO() {
		
	}
	
	public List<Deltager> hentAlleDeltagere() {
		return em.createQuery("SELECT d FROM Deltager d", Deltager.class).getResultList();
	}
	
	public Deltager hentDeltager(String mobil) {
		return em.find(Deltager.class, mobil);
	}

	public void leggTilNyDeltager(Deltager d) {
		em.persist(d);
		System.out.println(d);
	}
	
	public boolean finnesMobilNr(String mobil) {
		return em.find(Deltager.class, mobil) != null;
	}
	
//	public static boolean finnes(String mobil) {
//		return hentDeltager(mobil) != null;
//	}
	
}
