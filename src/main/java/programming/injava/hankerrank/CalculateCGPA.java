package programming.injava.hankerrank;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Stream;

public class CalculateCGPA {
	
	public static void main(String[] args) {
		
		Map<String, Map<String, List<Double>>> students = new HashMap<String, Map<String, List<Double>>>();
		
		 List<Double> sub1Marks = new ArrayList<Double>();
		 sub1Marks.add(4.4);
		 sub1Marks.add(6.9);
		 sub1Marks.add(8.3);
		 sub1Marks.add(7.8);
		 
		 List<Double> sub2Marks = new ArrayList<Double>();
		 sub2Marks.add(14.4);
		 sub2Marks.add(16.9);
		
		 
		 Map<String, List<Double>> studMarks = new HashMap<String, List<Double>>();
		 
		 studMarks.put("SEM-1", sub1Marks);
		 studMarks.put("SEM-2", sub2Marks);
		 
		 students.put("RUDRA", studMarks);
		 students.put("SHIVA", studMarks);

		 Map<String, Map<String, Double>> cgpa = new HashMap<String, Map<String,Double>>();
		 
		 students.entrySet().forEach(e -> {
			 Map<String, Double> t = new HashMap<>();
			 e.getValue().entrySet().forEach(m -> {
				 double marks = m.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
				 t.put(m.getKey(), marks);
			 });
			 cgpa.put( e.getKey(), t);
		 });
		 
		 System.out.println(cgpa);
		 
		 Map<String, Map<String, Double>> cgpa1 = students.entrySet().stream().collect(toMap(Entry::getKey, 
				 sem -> sem.getValue().entrySet().stream().collect(toMap(Entry::getKey, 
						 marks -> marks.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()))));
		 
		 System.out.println(cgpa1);
		 
		 Map<Object, Object> cgpa2 = students.entrySet().stream().collect(toMap(Entry::getKey, Function.identity()));
		 
		 System.out.println(cgpa2);
		 
		 
		 int max = Stream.iterate(0, n -> n+1).limit(55).max((e1, e2) -> e1 - e2).get();
		 System.out.println(max);
		 
		 max = Stream.iterate(0, n -> n+1).limit(55).reduce(0, (e1, e2) -> e1 > e2 ? e1 : e2);
		 System.out.println(max);
		 
		 
	}

}

class StudentV1 {
	String name;
	List<Semester> semesters;
	
	public StudentV1(String name, List<Semester> semesters) {
		super();
		this.name = name;
		this.semesters = semesters;
	}
}

class Semester {
	int semesterId;
	Map<Integer, List<Subject>> students = new HashMap<Integer, List<Subject>>();
	
	public Semester(int semesterId) {
		super();
		this.semesterId = semesterId;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public Map<Integer, List<Subject>> getStudents() {
		return students;
	}

	public void setStudentsSubjs(Integer rollNo, List<Subject> subjects) {
		this.students.put(rollNo, subjects);
	}
}

class Subject {
	String name;
	double marks;
	
	public Subject(String name, double marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
}