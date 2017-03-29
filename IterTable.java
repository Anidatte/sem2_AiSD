package aisd_lista1;


public class IterTable implements Iterator {
	
	final Object [] tab;
	final int first;
	final int last;
	int curr=-1;
	
	public IterTable(Object [] t)
	{
		tab = t;
		first = 0;
		last = tab.length-1;
	}
	
	public void first()
	{
		curr = first;
	}
	
	public void last()
	{
		curr = last;
	}
	
	public void next()
	{
		++curr;
	}
	
	public void previous()
	{
		--curr;
	}
	
	public boolean isDone()
	{
		return curr < first || curr > last;
	}
	
	public Object current()
	{
		return tab [ curr ];
	}
	
	public int currentIndex()
	{
		return curr;
	}
}
