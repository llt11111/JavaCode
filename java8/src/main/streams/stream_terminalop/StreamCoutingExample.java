package main.streams.stream_terminalop;

import main.data.Student;
import main.data.StudentData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamCoutingExample {
    public static void main(String[] args) {
        System.out.println(count());
        min();
        min1();
        minByExample();
    }
    public static long count(){
        return StudentData.getAllStudents().stream()
                .collect(Collectors.counting());
    }
    public static void mapNames(){
        List<String> names =  StudentData.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));
    }
    public static void min(){
         Optional<Student> st = StudentData.getAllStudents().stream()
                .min(comparing(Student::getGradeLevel));
        System.out.println(st.get());
    }
    public static void min1(){
        Optional<Student> st = StudentData.getAllStudents().stream()
//                .map(Student::getGradeLevel)
                .min(Comparator.comparing(Student::getGradeLevel));
        System.out.println(st.get());
    }
    public static void minByExample(){
        Optional<Student> st = StudentData.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGradeLevel)));
        System.out.println(st.get());
    }
}
