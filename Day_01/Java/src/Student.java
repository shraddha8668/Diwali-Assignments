import java.io.Serializable;

public class Student implements Serializable{
	private int rollno;
	private String sname;
	private String course;
	private double attendance_percentage;
	private int score;
	
	public Student() {
		super();
	}

	public Student(int rollno, String sname, String course, double attendance_percentage, int score) {
		this.rollno = rollno;
		this.sname = sname;
		this.course = course;
		this.attendance_percentage = attendance_percentage;
		this.score = score;
	}
	
	public String calculateGrade() throws LowAttendanceException {
		if(attendance_percentage <60) {
			throw new LowAttendanceException("student "+sname +" has low attendance");
		}
		if(score>=90) {return "A";}
		else if(score>=75) {return "B";}
		else if(score>=60) {return "C";}
		else {return "D";}
		
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getAttendance_percentage() {
		return attendance_percentage;
	}

	public void setAttendance_percentage(double attendance_percentage) {
		this.attendance_percentage = attendance_percentage;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", course=" + course + ", attendance_percentage="
				+ attendance_percentage + ", score=" + score + "]";
	}
	
	

}
