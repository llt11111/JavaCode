package main.consume;

import main.data.Student;
import main.data.StudentData;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> add = (a, b) -> {
            System.out.println("sum is : "+ (a + b));
        };

        add.accept(10, 5);
        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("multiply is : "+ (a* b));
        };
        BiConsumer<Integer, Integer> division = (a, b) -> {
            System.out.println("division is : "+ (a/b));
        };

        multiply.accept(10, 5);

        multiply.andThen(division).accept(10, 5);
        printNameandActivites();
    }

    public static void printNameandActivites(){
        List<Student> studentList = StudentData.getAllStudents();
        BiConsumer<String, List<String>> p = (name, activities) -> {
            System.out.println(name + " and activities : "+ activities);
        };
        studentList.forEach( (student) -> {
            p.accept(student.getName(), student.getActivities());
        });
    }
}
