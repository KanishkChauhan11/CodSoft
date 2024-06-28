import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many subjects do you have? ");
        int subjectCount = scanner.nextInt();

        if (subjectCount <= 0) {
            System.out.println("Please enter a valid number of subjects greater than zero.");
            scanner.close();
            return;
        }

        int[] scores = new int[subjectCount];
        int totalScores = 0;
        int totalPossibleScores = 0;

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter the total possible score for subject " + (i + 1) + ": ");
            int maxScore = scanner.nextInt();
            while (maxScore <= 0) {
                System.out.print("The total possible score must be a positive number. Try again: ");
                maxScore = scanner.nextInt();
            }

            System.out.print("Enter the score you received for subject " + (i + 1) + ": ");
            int score = scanner.nextInt();
            while (score < 0 || score > maxScore) {
                System.out.print("The score should be between 0 and " + maxScore + ". Please re-enter: ");
                score = scanner.nextInt();
            }

            totalPossibleScores += maxScore;
            scores[i] = score;
            totalScores += score;
        }

        double percentage = (double) totalScores / totalPossibleScores * 100;
        String grade;

        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
            System.out.println(" You are failed in the exam");
        }

        System.out.println("You scored a total of: " + totalScores + " out of " + totalPossibleScores);
        System.out.println("Your average percentage is: " + percentage + "%");
        System.out.println("You received a grade: " + grade);

        scanner.close();
    }
}
