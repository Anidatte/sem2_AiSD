package aisd_lista1;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("aisd_lista1");
		
		StudentsList tmp = new StudentsList();
		tmp.Show();
		
		tmp.SetRate(200833, 2.0);
		
		System.out.println("$$$");
		tmp.Show();
		
		System.out.println("Œrednia");
		System.out.println(tmp.PassedAverage());
		
		tmp.ShowFailed();
		
		System.out.println("$$$ dodawanie $$$");
		tmp.AddStudent(200833, "John", "Smith", 4.0);
		tmp.AddStudent(201100, "John", "Smith", 4.0);
		tmp.AddStudent(200400, "Lucy", "Gree", 5.0);
		tmp.AddStudent(201099, "James", "Lock", 3.5);
		tmp.AddStudent(200833, "James", "Lock", 3.5);
		tmp.Show();
		
		System.out.println("$$$ usuwanie $$$");
		tmp.RemoveStudent(200842);
		tmp.RemoveStudent(200211);
		tmp.RemoveStudent(200400);
		tmp.RemoveStudent(201100);
		tmp.Show();
	}
	
	
}
