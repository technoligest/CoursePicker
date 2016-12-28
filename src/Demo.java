
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Demo {
	public static void main(String[]args){
		try{
			Scanner br = new Scanner(new FileReader("Timetable Information Aug 10 2016.csv"));
			TimeTable t= IO.readTimeTable(br);
			br= new Scanner(new FileReader("student1.csv"));
			Student s= IO.readStudent(br);

			br= new Scanner(new FileReader("CS Degree Requirements 2.csv"));
			Degree d= IO.readDegree(br);

			HashMap<String, Degree> degrees= new HashMap();
			degrees.put(d.getName(), d);

			University dal= new University("Dalhousie",degrees,t);
			Student.setUniversity(dal);

			System.out.println(s);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
