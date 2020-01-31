package main.consume;

import main.data.StudentData;
import main.data.Student;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerTests {
    public static void main(String[] args) {

        Consumer<String> con = (s)-> System.out.println(s.toUpperCase());
        con.accept("java 8");

        Stream.of("ram", "raven").forEach(con);
        System.out.println(getAllStudentsName());

        getAllStudentsName_();

        printNameAndActivites();

        printStudentHavingGpaMoreThanThree();
    }
    public static List<String> getAllStudentsName(){
        return StudentData.getAllStudents().stream().map(s -> s.getName()).collect(Collectors.toList());
    }

    static Consumer<Student> c1 = (student) -> System.out.print(student.getName());
    static Consumer c2 = (Student) -> System.out.print(" performs ");
    static Consumer<Student> c3 = (student) -> System.out.println(student.getActivities().toString());


    public static void getAllStudentsName_(){
        Consumer<Student> c = (student) -> System.out.println(student.getName());
        StudentData.getAllStudents().forEach(c);
    }

    public static void printNameAndActivites(){

        StudentData.getAllStudents().forEach(c1.andThen(c2).andThen(c3));

    }
    public static void printStudentHavingGpaMoreThanThree(){
       StudentData.getAllStudents().forEach( (student -> {
           if(student.getGpa() >=3){
              c1.andThen(c2).andThen(c3).accept(student);
           }
       }));
    }
}
