package exercises.exercise1;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Session session = new Session();
        for (int i = 1; i <= 20; i++) {
            String studentName = "Student" + i;
            Student student;

            if (i % 2 == 0) {
                student = new FullTimeStudent(studentName, getRandomScore(), getRandomScore());
            } else {
                student = new PartTimeStudent(studentName);
            }

            for (int j = 1; j <= 15; j++) {
                FullTimeStudent.addExamScores(getRandomScore());
            }

            session.addStudent(student);
        }


        double classAverage = session.calculateAverage();
        System.out.println("Average Quiz Scores for the Whole Class: " + classAverage);

        session.ScoresAscending();
        session.printStudentTypes();
    }


    private static int getRandomScore() {
        Random random = new Random();
        int min = 60;
        int max = 100;
        return random.nextInt(max - min + 1) + min;
    }
}
