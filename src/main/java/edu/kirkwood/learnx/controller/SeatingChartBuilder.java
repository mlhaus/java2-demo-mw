package edu.kirkwood.learnx.controller;

import java.util.List;
import edu.kirkwood.learnx.data.StudentDAO;
import edu.kirkwood.learnx.model.Student;

public class SeatingChartBuilder {
    public static void main(String[] args) {
        List<Student> students = StudentDAO.getSampleStudents();
        for(Student student: students) {
            System.out.println(student);
        }
    }
}
