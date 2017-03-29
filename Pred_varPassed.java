package aisd_lista1;

public class Pred_varPassed implements Predicate{
	@Override
	public boolean accept(Object o) {
		// TODO Auto-generated method stub
		
		Student tmp = (Student) o;
		if(tmp.aisd_rate >= 3.0)
		{
			return true;
		}
		return false;
	}
}
