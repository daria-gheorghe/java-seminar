package exceptions;

import java.util.Scanner;
//erorile sunt evenimente catrastofale, probleme grave ale sistemului : OutOfMemoryError, StackOverflowError
//exceptiile pot fi gestionate de program
// !!nu opresc executia codului - exceptia opreste executia blocului try, dar nu opreste programul daca exista catch



//Throwable clasa parinte
//aici avem Errors si Exeception(unchecked sau checked)

//        Throwable
//           |
//           |-- Error
//           |
//           |-- Exception
//                  |
//                  |-- RuntimeException (unchecked)
//                  |       |
//                  |       |-- NullPointerException
//                  |       |-- ArithmeticException
//                  |       |-- ArrayIndexOutOfBoundsException
//                  |       |-- IllegalArgumentException
//                  |
//                  |-- IOException
//                  |
//                  |-- SQLException
//                  |
//                  |-- ClassNotFoundException

//RunTimeExceptions(nu esti obligat sa le tratezi) sau CheckedExceptions(esti obligat sa faci try-catch sau throws)

//finally se executa mereu si avem nevoie de ea pt ca sunt anumite obiecte pe care le instantiem
//ex: ruleaza pe fundal(Scanner) si trb inchis(e o conexiune la consola)
//evitam memory leaks
//valabil si pt fisiere si bd


//e.getStackTrace: arata traseul executiei programului pana la momentul erorii
//este folosit pt debugging

public class ExceptionSeminar {
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);   //creeaza un obiect care citeste input de la tastatura

//        Java face următorul lucru:
//        1.	Apare o excepție
//        2.	Se uită la tipul excepției
//        3.	Caută primul catch compatibil
        try {
            System.out.print("Enter first number: ");
            int a = Integer.parseInt(scanner.nextLine());   //se citeste un text si se transforma in int
                                //daca scrii 'abc' nu il poate transforma, arunca 'NumberFormatException' -ajung in catch - afiseaza mesajul

            System.out.print("Enter second number: ");
            int b = Integer.parseInt(scanner.nextLine());   //la fel ca la a

            int result = divide(a, b);  //metoda scrisa mai jos
            System.out.println("Result: " + result);    //daca b=0, arunca 'ArithmetiException' - ajunge in catch- afiseaza mesajul

            String studentName = null;  //variabila nu refera niciun obiect
            printStudentName(studentName);  //apeleaza metoda definita mai jos
            // in metoda ai name.length() -> nu exista obiect -> nu poate apela metoda -> arunca 'NullPointerException'

            int[] grades = {10, 9, 8};
            System.out.println("Grade: " + grades[5]);  //array-ul are doar 3 elemente -> arunca 'ArrayIndexOutOfBoundsException'

        //e = obiect de tipul exceptiei
        }
        catch (ArithmeticException e)
        {
            System.out.println("Arithmetic error: " + e.getMessage());  //getMessage= metoda din clasa Throwable, ea returneaza mesajul intern al exceptiei
            //mesajele pt exceptii pot fi built-in sau puse de programator
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid number format.");
        }
        catch (NullPointerException e)
        {
            System.out.println("Student name is missing.");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid array index.");
        }
        catch (Exception e)
            { //Exception=clasa parinte pt toate exceptiile, se pune la final
            // daca era pus primul ar prinde toate exceptiile, iar celelalte catch-uri nu s-ar mai executa
            System.out.println("General error: " + e.getMessage());
        }
        finally //se executa intotdeauna, chiar daca apare eroare
        {   //roluri : inchidere fisiere, inchidere conexiuni, curatare resurse
            System.out.println("Program ended.");
            scanner.close();
        }

        System.out.println("Isi continua executia");
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static void printStudentName(String name)
    {
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
