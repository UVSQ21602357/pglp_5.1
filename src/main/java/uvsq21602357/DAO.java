package uvsq21602357;

public abstract class DAO<T> {
    
	  public abstract T creer(T obj);

	  public abstract T trouve(String id);

	  public abstract T actualise(T obj);

	  public abstract void supprime(T obj);
	}  