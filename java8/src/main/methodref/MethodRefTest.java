package main.methodref;

import main.data.StudentData;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodRefTest {
    public static void main(String[] args) {
        Function<String, String> toUpperLamda =  s -> s.toUpperCase();
        Function<String, String> toUpperLamdaRef =  String::toUpperCase;
        System.out.println(toUpperLamda.apply("lalit"));
        System.out.println(toUpperLamdaRef.apply("lalit"));

        printStudentAcitivites();
    }

    private static void printStudentAcitivites() {
        Consumer<List<String>> c2 = System.out::println;
        StudentData.getAllStudents().forEach(s -> c2.accept(s.getActivities()));
    }
}
