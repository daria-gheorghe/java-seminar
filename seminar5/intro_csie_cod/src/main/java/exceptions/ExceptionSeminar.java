package exceptions;

import java.util.Scanner;

public class ExceptionSeminar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter second number: ");
            int b = Integer.parseInt(scanner.nextLine());

            int result = divide(a, b);
            System.out.println("Result: " + result);

            String studentName = null;
            printStudentName(studentName);

            int[] grades = {10, 9, 8};
            System.out.println("Grade: " + grades[5]);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (NullPointerException e) {
            System.out.println("Student name is missing.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index.");
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        } finally {
            System.out.println("Program ended.");
            scanner.close();
        }

        System.out.println("Isi continua executia");
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static void printStudentName(String name) {
        System.out.println("Student name length: " + name.length());
    }

//-custom exception class usage example
//    public static void addGrade(int grade) throws InvalidGradeException {
//
//        // validate grade before storing it
//        validateGrade(grade);
//
//        System.out.println("Grade successfully added: " + grade);
//    }
//
//    import java.util.Scanner;
//
//    public class StudentApp {
//
//        public static void main(String[] args) {
//
//            Scanner scanner = new Scanner(System.in);
//
//            try {
//                System.out.print("Enter grade: ");
//                int grade = scanner.nextInt();
//
//                addGrade(grade);
//
//            } catch (InvalidGradeException e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//
//            scanner.close();
//        }
//
//        public static void validateGrade(int grade) throws InvalidGradeException {
//            if (grade < 1 || grade > 10) {
//                throw new InvalidGradeException("Grade must be between 1 and 10.");
//            }
//        }
//
//        public static void addGrade(int grade) throws InvalidGradeException {
//            validateGrade(grade);
//            System.out.println("Grade stored: " + grade);
//        }
//    }
}
