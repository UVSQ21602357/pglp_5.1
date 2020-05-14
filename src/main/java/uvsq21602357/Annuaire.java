package uvsq21602357;

import java.io.Serializable;



public class Annuaire implements Serializable {

  private static final long serialVersionUID = 1L;
  private static Annuaire ANNUAIRE;
  private PersonnelComposite  head;

  private Annuaire() {
    head = new PersonnelComposite(1);
  }

  /**
   * Public constructor for singleton.
   * @return Static reference to the object   
   **/
  public static Annuaire getInstance() {
    if (ANNUAIRE == null) {
      ANNUAIRE = new Annuaire();
    }
    return ANNUAIRE;
  }

  public void AjouteGroupe(PersonnelComposite  pc) {
    head.add(pc);
  }

  public void SupprimeGroupe(PersonnelComposite  pc) {
    head.remove(pc);
  }

  public GroupeIt getIterator() {
    return ANNUAIRE.head.groupeIteration();
  }

  
}
