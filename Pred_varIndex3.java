package aisd_lista1;

public class Pred_varIndex3 implements Predicate {

	int lim;
	
	public Pred_varIndex3(int i)
	{
		lim = i;
	}
	
	@Override
	public boolean accept(Object o) {
		// TODO Auto-generated method stub
		Student tmp = (Student) o;
		if(tmp.index_number > lim)
		{
			return true;
		}
		return false;
	}

}
