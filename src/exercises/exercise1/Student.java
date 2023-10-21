package exercises.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    public String name;
    private static List<Integer> ExamScores;

    public Student(String name, List<Integer> ExamScores) {
        this.name = name;
        this.ExamScores = new ArrayList<>(ExamScores);
    }
    public double calculateAverage(){
        int totalScore = 0;
        for(int Score : ExamScores){
            totalScore += Score;
        }
        return (double) totalScore / ExamScores.size();
    }

    public static void addExamScores(int score){
        ExamScores.add(score);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getExamScores() {
        return ExamScores;
    }

    public void printStudentType() {
        System.out.println("Student: " + name);
    }
}

class PartTimeStudent extends Student{
    public PartTimeStudent (String name){
        super(name, new ArrayList<Integer>());
    }
    public void printStudentType() {
        System.out.println("Part-Time Student: " + name);
    }
}

class FullTimeStudent extends Student{
    private int ExamScore1;
    private int ExamScore2;

    public FullTimeStudent (String name, int ExamScore1, int ExamScore2){
        super(name, new ArrayList<Integer>());
        this.ExamScore1 = ExamScore1;
        this.ExamScore2 = ExamScore2;
    }

    public int getExamScore1() {
        return ExamScore1;
    }

    public int getExamScore2() {
        return ExamScore2;
    }
    public void printStudentType() {
        System.out.println("Full-Time Student: " + name);
    }
}

class Session{
    private List<Student> students;
    public Session(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double calculateAverage() {
        double totalAverage = 0.0;
        for (Student student : students) {
            totalAverage += student.calculateAverage();
        }
        return totalAverage / students.size();
    }


    public void ScoresAscending(){
        List<Integer> allScores = new ArrayList<>();
        for(Student student : students){
            allScores.addAll(student.getExamScores());
        }
        Collections.sort(allScores);
        System.out.println("The list of quiz scores in ascending order for one session: ");
        for(int score : allScores){
            System.out.print(score + " ");
        }
        System.out.println();
    }
    public void printStudentTypes() {
        System.out.println("Student Types in the Session:");
        for (Student student : students) {
            student.printStudentType();
        }
    }
}



