package aisd_lista1;

public class IterFiltering implements Iterator
{
	private final Iterator iterf;
	private final Predicate pred;
	
	public IterFiltering (Iterator i, Predicate p) 
	{
		iterf=i; 
		pred=p; 
		iterf.first();
	}
	
	public void filterForward() 
	{
		while (!iterf.isDone() && !pred.accept( iterf.current()) )
		iterf.next();
	} 
	
	public void filterBackward()
	{
		while( !iterf.isDone() && !pred.accept( iterf.current()) )
		iterf.previous();
	}
	
	public void first()
	{ 
		iterf.first();
		filterForward(); 
	}
	
	public void last()
	{ 
		iterf.last();
		filterBackward();
	}
	
	public void next()
	{
		iterf.next();
		filterForward();
	}
	
	public void previous()
	{
		iterf.previous();
		filterBackward();
	}
	
	public boolean isDone()
	{
		return iterf.isDone();
	}
	
	public Object current()
	{
		return iterf.current();
	}
}
