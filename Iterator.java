package aisd_lista1;

public interface Iterator {

	public void previous(); 
	public void next();
	public void first(); 
	public void last(); 
	public boolean isDone(); 
	public Object current();
	
}
