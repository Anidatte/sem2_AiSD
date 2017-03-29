package aisd_lista1;

public class Pred_varIndex implements Predicate{

	int index;
	
	public Pred_varIndex(int i)
	{
		index = i;
	}
	
	@Override
	public boolean accept(Object o) {
		// TODO Auto-generated method stub
		
		Student tmp = (Student) o;
		if(tmp.index_number == index)
		{
			return true;
		}
		return false;
	}
}