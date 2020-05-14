package uvsq21602357;

import java.util.ArrayDeque;


public class GroupeIt extends PersonnelTypeIterator {
     
       public GroupeIt(final PersonnelComposite compositePersonnel) {
              super(compositePersonnel, new ArrayDeque<PersonnelType>());

       }
       
       @Override
       protected PersonnelType getCollectionItems() {
         return ((ArrayDeque<PersonnelType>) getPersonnelCollection()).remove();
       }

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public PersonnelType next() {
		// TODO Auto-generated method stub
		return null;
	}

}
