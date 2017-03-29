package aisd_lista1;

public class StudentsList {
	
	Student [] Array;
	int currentSize;
	IterTable itab;
	
	/* 
	 * Contruct
	 */
	
	public StudentsList()
	{
		/*
		 *  Load sample data to array
		 */
		
		Array = new Student [10];
		currentSize = Array.length;
		Array[0] = new Student("Michal", "Fulat", 200833, 5.0);
		Array[1] = new Student("Rafal", "Bieganski", 200834, 4.0);
		Array[2] = new Student("Andrzej", "Zajac", 200835, 4.5);
		Array[3] = new Student("Marysia", "Szpadkowska", 200836, 5.5);
		Array[4] = new Student("Krasnal", "Nowakowski", 200837, 2.0);
		Array[5] = new Student("Dawid", "Strzelecki", 200838, 3.5);
		Array[6] = new Student("Jarek", "Mierzwa", 200839, 3.0);
		Array[7] = new Student("Dominik", "Zajaczkowski", 200840, 2.0);
		Array[8] = new Student("Mariusz", "Adamek", 200841, 5.0);
		Array[9] = new Student("Robert", "Stelmach", 200842, 4.5);
		
		itab = new IterTable(Array);
	}
	
	/*
	 * Shows entire students list
	 * 
	 */
	
	public void Show()
	{		
		for (itab.first(); !itab.isDone(); itab.next())
		{
			Student tmp = (Student) itab.current();
			tmp.Show();
		}
	}
	
	/*
	 * Sets a grade to student by index number
	 * 
	 */
	
	public int SetRate (int idx, double d)
	{
		Pred_varIndex pred = new Pred_varIndex (idx);
		IterFiltering ftab = new IterFiltering (itab, pred);
		
		ftab.filterForward();
		
		if (ftab.current() != null)
		{
			Array[itab.currentIndex()].SetAisdRate(d);
			return 0;
		}
		
		return 1;
	}
	
	/*
	 * calculate average of passed grades
	 * 
	 */
	
	public double PassedAverage()
	{
		double sum = 0;
		int count = 0;
		Pred_varPassed pred = new Pred_varPassed ();
		IterFiltering ftab = new IterFiltering (itab, pred);
		
		for (ftab.first(); !ftab.isDone(); ftab.next())
		{
			Student tmp = (Student) itab.current();
			sum = sum + tmp.aisd_rate;
			count++;
		}
		
		return (double) sum / count;
	}
	
	/*
	 * list of student who's failed
	 * 
	 */
	
	public void ShowFailed()
	{
		Pred_varFailed pred = new Pred_varFailed ();
		IterFiltering ftab = new IterFiltering (itab, pred);
		
		for (ftab.first(); !ftab.isDone(); ftab.next())
		{
			Student tmp = (Student) itab.current();
			tmp.Show();
		}
	}
	
	/*
	 * add new student to list
	 * protection for adding student with same index number
	 * 
	 */
	
	public int AddStudent (int idx, String fname, String lname, double aisd_rate)
	{
		int count = 0;
		Student [] ArrayT = new Student[currentSize+1];
		
		Pred_varIndex2 pred = new Pred_varIndex2 (idx);
		Pred_varIndex pred2 = new Pred_varIndex (idx);
		Pred_varIndex3 pred3 = new Pred_varIndex3 (idx);
		
		IterFiltering ftab = new IterFiltering (itab, pred2);
		
		ftab.filterForward();
		
		if (!ftab.isDone())
		{
			return -1;
		}
		
		ftab = new IterFiltering (itab, pred);
		
		for (ftab.first(); !ftab.isDone(); ftab.next())
		{
			ArrayT[count] = (Student) ftab.current();
			count++;
		}
		
		ArrayT[count] = new Student (fname, lname, idx, aisd_rate);
		count++;
		ftab = new IterFiltering (itab, pred3);
		
		for (ftab.first(); !ftab.isDone(); ftab.next())
		{
			ArrayT[count] = (Student) ftab.current();
			count++;
		}
		
		Array = ArrayT;
		itab = new IterTable(Array);
		currentSize++;
		return 0;
	}
	
	/*
	 *  removes student from list based on index number
	 * 
	 */
	
	public int RemoveStudent (int idx)
	{
		int count = 0;
		Student [] ArrayT = new Student[currentSize-1];
		IterTable itab2 = new IterTable(Array);
		
		Pred_varIndex2 pred = new Pred_varIndex2 (idx);
		Pred_varIndex pred2 = new Pred_varIndex (idx);
		Pred_varIndex3 pred3 = new Pred_varIndex3 (idx);
		
		IterFiltering ftab = new IterFiltering (itab2, pred2);
		ftab.filterForward();
		
		if (ftab.isDone())
		{
			System.out.println("Usuwanie "+idx+" nieudane");
			return -1;
		}
		
		ftab = new IterFiltering (itab, pred);
		
		for (ftab.first(); !ftab.isDone(); ftab.next())
		{
			ArrayT[count] = (Student) ftab.current();
			count++;
		}
		
		ftab = new IterFiltering (itab, pred3);
		
		for (ftab.first(); !ftab.isDone(); ftab.next())
		{
			ArrayT[count] = (Student) ftab.current();
			count++;
		}
		
		Array = ArrayT;
		itab = new IterTable(Array);
		currentSize--;
		return 0;
	}
}
