package uvsq21602357;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonnelComposite  extends PersonnelType implements Iterable<PersonnelType> {
    private List<PersonnelType> Personnel;
    private int identifiant;
    
       public void add(final PersonnelType personnel) {
              this.Personnel.add(personnel);
          }
       public PersonnelComposite(final int idGroupe) {
              this.Personnel = new ArrayList<PersonnelType>();
              this.identifiant = idGroupe;
       }
       public void remvoe(final PersonnelType personnel) {
              this.Personnel.remove(personnel);
       }
    public List<PersonnelType> getAllPersonnel() {
           return this.Personnel;
    }
       @Override
       public boolean EstUnGroupe() {

              return true;
     }

       public Iterator<PersonnelType> iterator() {

              return Personnel.listIterator();
       }
       public GroupeIt groupeIteration() {
              return new GroupeIt(this);
       }
       public HierarchieIt hierachical() {
              return new HierarchieIt(this);
       }
       @Override
       public String toString() {
              return "identifiant " + this.identifiant;
       }
}