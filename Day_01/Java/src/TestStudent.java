import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"shraddha","DAC",100,85));
		students.add(new Student(2,"shrawani","DBDA",95,99));
		students.add(new Student(3,"neeta","DAI",65,75));
		students.add(new Student(4,"manoj","DAI",80,85));
		students.add(new Student(5,"dipti","DBDA",75,60));
		students.add(new Student(6,"sagar","DAC",50,40));
		students.add(new Student(7,"rishika","DAC",60,50));
		students.add(new Student(8,"ridhant","DAI",45,63));
		students.add(new Student(9,"piya","DAC",89,77));
		students.add(new Student(10,"sandy","DBDA",33,33));
	
		
		 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
	            oos.writeObject(students);
	            System.out.println("Students serialized successfully!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        students.sort((s1, s2) -> Double.compare(s2.getAttendance_percentage(), s1.getAttendance_percentage()));

	        System.out.println("\nStudents sorted by attendance:");
	        for (Student s : students) {
	            System.out.println(s);
	        }
	}

}
