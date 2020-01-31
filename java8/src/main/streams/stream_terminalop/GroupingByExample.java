package main.streams.stream_terminalop;

import main.data.Student;
import main.data.StudentData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {
    public static void main(String[] args) {
        groupStudentsByGender();
        groupStudentsByGpa();
        System.out.println();
        twoLevelGrouping();
    }

    public static void groupStudentsByGender() {
        Map<String, List<Student>> stringListMap = StudentData.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(stringListMap);
    }
    public static void groupStudentsByGpa() {
        Map<String, List<Student>> stringListMap = StudentData.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> student.getGpa()>=3.9 ? "topper": "fuddu"));
//        System.out.println(stringListMap.values());
        stringListMap.entrySet().stream().forEach(s -> {
            System.out.println("key : "+ s.getKey() + " value : "+ s.getValue());
        });

    }
    public static void twoLevelGrouping() {
        Map<Integer, Map<String, List<Student>>> map = StudentData.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel ,
                        Collectors.groupingBy(st -> st.getGpa()>= 3.9 ? "top": "avg")));
//                .collect(Collectors.groupingBy(student -> student.getGpa()>=3.9 ? "topper": "fuddu"));
//        System.out.println(stringListMap.values());
        map.entrySet().stream().forEach(s -> {
            System.out.println("key : "+ s.getKey() + " value : "+ s.getValue());
        });
    }
}
