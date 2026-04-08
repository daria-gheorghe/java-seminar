package readingFiles;

import java.nio.file.Path;

import static readingFiles.FileDemo.*;

public class Main {
    //Java Standard I/O
//    System.in   // input (keyboard)
//    System.out  // standard output (console)
//    System.err  // error output (console)
// Standard I/O is how your program communicates with the outside world — mainly through the console.
// Java File I/O

    public static void main(String[] args) {
        Path path = Path.of("students.txt");

        writeFile(path);    //apeleaza metoda:  public static void writeFile(Path path)
        readFile(path); //apeleaza : public static void readFile(Path path)
    }

}
