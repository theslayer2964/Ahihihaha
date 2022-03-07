package iuh.fit.servlet2;

import java.util.ArrayList;
import java.util.List;

public class StudentdataUtil {
	public static List<Student> getStudents(){
		
List<Student> students = new ArrayList();
		
		students.add(new Student("Tri", "Hoang", "xxx@gmail.com"));
		students.add(new Student("Chi", "Nguyen", "xxx@gmail.com"));
		students.add(new Student("Trinh", "Ho", "xxx@gmail.com"));
		return students;
	}
}
