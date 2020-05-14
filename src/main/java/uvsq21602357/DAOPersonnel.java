package uvsq21602357;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAOPersonnel extends DAO<Personnel> {

  @Override
  public Personnel creer(Personnel p) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(p.getNom()))) {
      out.writeObject(p);
    } catch (IOException ioe) {
    	System.out.println("Erreur");
      ioe.printStackTrace();
    }
    return p;
  }

  @Override
  public Personnel trouve(String str) {
    Personnel personnel = null;
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(str))) {
      personnel = (Personnel) in.readObject();
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
    return personnel;
  }

  @Override
  public Personnel actualise(Personnel p) {
    String str = p.getNom();
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(str, false))) {
      out.writeObject(p);
    } catch (IOException ioe) {
    	System.out.println("Erreur");
      ioe.printStackTrace();
    }
    return p;
  }

  @Override
  public void supprime(Personnel p) {

    File file = new File(p.getNom());
    boolean suppr = file.delete();
    if (suppr == false) {
      System.out.println("echec de la suppression");
    } else {
      System.out.println("suppression reussi");
    }
  }
}