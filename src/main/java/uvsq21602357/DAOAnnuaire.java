package uvsq21602357;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAOAnnuaire extends DAO<Annuaire> {


  @Override
  public Annuaire creer(Annuaire ann) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Annuaire"))) {
      out.writeObject(ann);
    } catch (IOException ioe) { 
    	System.out.println("Erreur");
      ioe.printStackTrace();
    }
    return ann;
  }

  @Override
  public Annuaire trouve(String str) {
    Annuaire annuaire = null;
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(str))) {
      annuaire = (Annuaire) in.readObject();
    
    } catch (ClassNotFoundException  ioe) {
    	System.out.println("Erreur");
      ioe.printStackTrace();
    } catch (FileNotFoundException e) {
    	System.out.println("Erreur");
      e.printStackTrace();
    } catch (IOException e) {
    	System.out.println("Erreur");
      e.printStackTrace();
    }
    return annuaire;
  }

  @Override
  public Annuaire actualise(Annuaire ann) {
    String file = "Annuaire";
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, false))) {
      out.writeObject(ann);
    } catch (IOException ioe) {
    	System.out.println("Erreur");
      ioe.printStackTrace();
    }
    return ann;
  }

  @Override
  public void supprime(Annuaire ann) {
    File file = new File("Annuaire");
    boolean suppr = file.delete();
    if (suppr == false) {
      System.out.println("echec de la suppression");
    } else {
      System.out.println("suppression réussi");
    }
  }
}