package uvsq21602357;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAOGroupe extends DAO<PersonnelComposite> {

  @Override
  public PersonnelComposite creer(PersonnelComposite PC) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Groupe" + PC.getID()))) {
      out.writeObject(PC);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return PC;
  }

  @Override
  public PersonnelComposite trouve(String str) {
    PersonnelComposite groupe = null;
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(str))) {
      groupe = (PersonnelComposite) in.readObject();
    } catch (ClassNotFoundException  ioe) {
      ioe.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return groupe;
  }

  @Override
  public PersonnelComposite actualise(PersonnelComposite PC) {
    String file = "Groupe" + PC.getID();
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, false))) {
      out.writeObject(PC);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return PC;
  }

  @Override
  public void supprime(PersonnelComposite obj) {
    File file = new File("Groupe" + obj.getID());
    boolean deleted = file.delete();
    if (deleted) {
      System.out.println("deleted");
    } else {
      System.out.println("not deleted");
    }
  }
}