package aisd_lista1;

public class Pred_varIndex2 implements Predicate {

	int lim;
	
	public Pred_varIndex2(int i)
	{
		lim = i;
	}
	
	@Override
	public boolean accept(Object o) {
		// TODO Auto-generated method stub
		Student tmp = (Student) o;
		if(tmp.index_number < lim)
		{
			return true;
		}
		return false;
	}

}
