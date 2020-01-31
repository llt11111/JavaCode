package main.streams;

import main.data.StudentData;
import main.data.Student;

import java.util.Optional;
import java.util.stream.IntStream;

public class StreamReduceExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 5);
//        Arrays.asList("lait","").stream()
//        int sum = intStream.sum();
//        System.out.println(intStream.sum());
//        System.out.println(sum);
        multiply(intStream);

        getHighestStudentGpa();
    }

    private static void getHighestStudentGpa() {
        Optional<Double> gpa = StudentData.getAllStudents().stream()
                .map(Student::getGpa)
                .reduce((s1, s2) -> {
                   return  s1>s2 ? s1 : s2;
                });
        Optional<Double> gpa1 = StudentData.getAllStudents().stream()
                .map(Student::getGpa)
//                .skip(1)
                .reduce(Double::sum);
        System.out.println(gpa.get());
        System.out.println(gpa1.get());
    }

    private static void multiply(IntStream intList) {
        int multiply = intList.reduce(1, (a, b) -> a*b);
        System.out.println(multiply);
    }
}
