package aisd_lista1;

public class Student {
	String fname;
	String lname;
	int index_number;
	double aisd_rate;
	
	public Student(String fn, String ln, int inx)
	{
		fname = fn;
		lname = ln;
		index_number = inx;
		aisd_rate = -1;
	}
	
	public Student(String fn, String ln, int inx, double r)
	{
		fname = fn;
		lname = ln;
		index_number = inx;
		aisd_rate = r;
	}
	
	public int SetAisdRate(double r)
	{
		if (r >= 2 && r <= 5.5)
		{
			aisd_rate = r;
			return 0;
		}
		
		return -1;
	}
	
	public boolean checkIdx(int i)
	{
		if (i == index_number)
			return true;
		else
			return false;
	}
	
	public void Show()
	{
		System.out.println(fname+" "+lname+" ("+index_number+") - AISD: " +aisd_rate);
	}
}
