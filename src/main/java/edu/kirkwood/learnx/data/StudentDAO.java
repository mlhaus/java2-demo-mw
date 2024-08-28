package edu.kirkwood.learnx.data;

import java.util.ArrayList;
import java.util.List;
import edu.kirkwood.learnx.model.Student;

public class StudentDAO {
    public static List<Student> getSampleStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student(1, "Marc", "Hauschildt", 12, 3.65));
        return students;
    }

    public static List<Student> getStudentsFromCSV() {
        return null;
    }
}
