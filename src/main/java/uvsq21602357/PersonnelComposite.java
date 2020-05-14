package uvsq21602357;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PersonnelComposite  extends PersonnelType implements Iterable<PersonnelType>, Serializable {
    private List<PersonnelType> Personnel;
    private static final long serialVersionUID = 1L;
    private int id;
    private int identifiant;
    
       public void add(final PersonnelType personnel) {
              this.Personnel.add(personnel);
          }
       public PersonnelComposite(final int idGroupe) {
              this.Personnel = new ArrayList<PersonnelType>();
              this.identifiant = idGroupe;
       }
       public void remove(final PersonnelType personnel) {
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
       
       public int getID() {
    	    return this.id;
    	  }

    	  @Override
    	  public int hashCode() {
    	    return Objects.hash(id);
    	  }

    	  @Override
    	  public boolean egale(Object obj) {
    	    if (this == obj) {
    	      return true;
    	    }
    	    if (obj == null) {
    	      return false;
    	    }
    	    if (!(obj instanceof PersonnelComposite)) {
    	      PersonnelComposite other = (PersonnelComposite) obj;
    	      return (id == other.id);
    	    }
    	    return false;
    	  }
}
