package uvsq21602357;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import uvsq21602357.Annuaire;
import uvsq21602357.DAO;
import uvsq21602357.DAOAnnuaire;
import uvsq21602357.PersonnelComposite;
import uvsq21602357.Personnel;
import uvsq21602357.PersonnelType;
import uvsq21602357.PersonnelTypeIterator;

public class DAOtest {

	
	

	DAO<Annuaire> dao;
	
	@Test
	public void creerTest(){
		Annuaire a = Annuaire.getInstance();
		File tmpDir = new File("Annuaire");
		tmpDir.delete();
		dao = new DAOAnnuaire();
		assertFalse(tmpDir.exists());
		dao.creer(a);
		assertTrue(tmpDir.exists());
	}
    
	
	
	@Test
	public void SupprimeTest(){
		Annuaire a = Annuaire.getInstance();
		File tmpDir = new File("Annuaire");
		dao = new DAOAnnuaire();
		dao.creer(a);
		assertTrue(tmpDir.exists());
		dao.supprime(a);
		assertFalse(tmpDir.exists());
		
	}

	@Test
	public void trouveTest(){
		creerTest();
		Annuaire c = dao.trouve("Annuaire");
		assertNotNull(c);
		
	}
  
}