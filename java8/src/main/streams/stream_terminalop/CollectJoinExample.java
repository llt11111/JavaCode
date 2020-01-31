package main.streams.stream_terminalop;

import main.data.StudentData;
import main.data.Student;

import java.util.stream.Collectors;

public class CollectJoinExample {
    public static void main(String[] args) {
        System.out.println("Joining 1 : " + joining1());
        System.out.println("Joining 2 : " + joining2());
        System.out.println("Joining 3 : " + joining3());
    }
    public static String joining1(){
        return StudentData.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }
    public static String joining2(){
        return StudentData.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining(" "));
    }
    public static String joining3(){
        return StudentData.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining(" ", "(", ")"));
    }
}
