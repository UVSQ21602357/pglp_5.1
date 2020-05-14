package uvsq21602357;

import java.util.Stack;

public class HierarchieIt extends PersonnelTypeIterator {
      
       public HierarchieIt(
       final PersonnelComposite compositePersonnel) {
              super(compositePersonnel, new Stack<PersonnelType>());

       }
      
       @Override
       protected PersonnelType getCollectionItems() {
              return ((Stack<PersonnelType>) getPersonnelCollection()).pop();
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
