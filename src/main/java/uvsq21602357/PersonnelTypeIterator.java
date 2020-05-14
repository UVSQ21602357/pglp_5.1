package uvsq21602357;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class PersonnelTypeIterator implements Iterator<PersonnelType> {
	
	private Collection<PersonnelType> personnelCollection;
    protected abstract PersonnelType getCollectionItems();
    
	public boolean ASuivant() {
            return !getPersonnelCollection().isEmpty();
      }
      
      private PersonnelComposite root;
      
      public PersonnelTypeIterator(final PersonnelComposite compositePersonnel, final Collection<PersonnelType> collection) {
          this.root = compositePersonnel;
          this.setPersonnelCollection(collection);
          this.getPersonnelCollection().addAll(root.getAllPersonnel());
      }
      
      private void setPersonnelCollection(final Collection<PersonnelType>collection) {
           this.personnelCollection = collection;
      }
      
      public PersonnelType Suivant() {
          if (!ASuivant()) {
                throw new NoSuchElementException();
          }
		  PersonnelType typePersonnel = getCollectionItems();
		  if (typePersonnel.EstUnGroupe()) {
		     getPersonnelCollection().addAll(((PersonnelComposite) typePersonnel).
		               getAllPersonnel());
		  }
		  return typePersonnel;
    }
    
  
    public PersonnelType getRoot() {
          return this.root;
    }
    
      public Collection<PersonnelType> getPersonnelCollection() {
          return personnelCollection;
     }
}