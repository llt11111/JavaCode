package main.consume;

import main.data.StudentData;
import main.data.Student;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateTest {
    static Predicate<Integer> p = (i) -> (i>4);
    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 2;
    static Predicate<Student> p2 = (s) -> s.getGpa() > 3.9;

    static BiPredicate<Integer, Double> p4 = (grade, gpa)-> grade>=2 && gpa>3.9;
    public static void main(String[] args) {


        System.out.println(" "+p.test(5));
        filterByGrade();
        System.out.println();
        filterByGpa();
        System.out.println();
        filterByGradeAndGpa();
        System.out.println();
        filterByGradeAndGpaWithBiPredicate();
    }

    public static void filterByGrade(){

        System.out.println("filterByGrade");
        List<Student> studentList = StudentData.getAllStudents();
        studentList.forEach((student -> {
            if(p1.test(student)){
                System.out.print(student.getName() + " ");
            }
        }));
    }
    public static void filterByGpa(){

        System.out.println("filterByGpa");
        List<Student> studentList = StudentData.getAllStudents();
        studentList.forEach((student -> {
            if(p2.test(student)){
                System.out.print(student.getName()+ " " );
            }
        }));
    }
    public static void filterByGradeAndGpa(){

        System.out.println("filterByGradeAndGpa");
        List<Student> studentList = StudentData.getAllStudents();
        studentList.forEach((student -> {

//            if(p1.test(student) && p2.test(student)){
            if(p1.and(p2).test(student)){
                System.out.print(student.getName()+ " " );
            }
        }));
    }
    public static void filterByGradeAndGpaWithBiPredicate(){
        Consumer<Student> con = (student) -> System.out.println(student.getName());
        System.out.println("filterByGradeAndGpaWithBiPredicate");
        List<Student> studentList = StudentData.getAllStudents();
        studentList.forEach((student -> {

            if(p4.test(student.getGradeLevel(), student.getGpa())){
                con.accept(student);
            }
        }));
    }
}
