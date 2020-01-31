package main.streams;

import main.data.StudentData;
import main.data.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        printName();
        namesSet();
        nameAndActivites();
        getListOfActivitites();
    }

    private static void printName() {
        List<String> names = Arrays.asList("ram","raghav", "manav");
        Consumer<String> c = System.out::print;
        names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).forEach(c);
        System.out.println();
    }

    private static void nameAndActivites() {
        Map<String, List<String>> map1 = StudentData.getAllStudents()
                .stream()
                .filter(s -> s.getGradeLevel()>= 3)
                .filter(s -> s.getGpa() >= 3.9)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(map1);
    }

    private static void namesSet() {
        Set<String> names = StudentData.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        System.out.println(names);
    }

    public static void getListOfActivitites(){
        List<String> studentList = StudentData.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(list -> list.stream())
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        long count = StudentData.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(list -> list.stream())
                .distinct()
                .count();
        System.out.println(count);

    }
}
