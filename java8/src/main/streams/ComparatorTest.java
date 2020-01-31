package main.streams;

import main.data.StudentData;
import main.data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> studentList = StudentData.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .map(Student::getName)
                .collect(Collectors.toList());
//                .forEach(student -> System.out.println(student.getName()));
        System.out.println(studentList);
    }
}
