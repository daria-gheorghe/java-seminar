package readingFiles;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileDemo {

    // 1. Write (overwrite)
    public static void writeFile(Path path)
    {
        try {   //scrierea in fisier poate esua -> trebuie tratata
            System.out.println("Writing to file...");
            Files.write(path, List.of   //scrie in fisier: locatia = path, continutul= lista de stringuri
              (
                    "Ana,20",
                    "Mihai,22",
                    "Elena,19"
              )
            );
//  Files.write() fără opțiuni suplimentare:
//	•	creează fișier dacă nu există
//	•	suprascrie dacă există
	        }
        catch (IOException e)
        {
            System.err.println("Error writing file: " + e.getMessage());
        }
//  Prinde erori de tip:
//	•	fișier blocat
//	•	permisiuni insuficiente
//	•	path invalid
//	•	disc indisponibil
    }

    // 2. Read file
    public static void readFile(Path path) {
        try
        {
            System.out.println("\nReading file:");  //afiseaza titlul sectiunii
            List<String> lines = Files.readAllLines(path);  //citeste tot fisierul intr o lista
            for (String line : lines) //Iterează fiecare linie din listă.
            {
                System.out.println(line);   //Afișează linia curentă in consola
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
//  Tratează eroare dacă:
//	•	fișierul nu există
//	•	nu poate fi citit
//	•	acces interzis
    }


    // 3. Append to file
    public static void appendToFile(Path path) //Metodă care adaugă text la finalul fișierului. Nu suprascrie continutul
    {
        try {
            System.out.println("\nAppending new student...");
            Files.write(path,
                    List.of("George,21"),
                    StandardOpenOption.APPEND   //adauga linia la finalul fisierului
            );
        } catch (IOException e) {
            System.err.println("Error appending file: " + e.getMessage());
        }
    }

    // 4. Check if file exists
    public static void checkIfExists(Path path)    // Verifică dacă fișierul există.
    {
        System.out.println("\nChecking if file exists...");
        if (Files.exists(path)) //Verifică existența fișierului.
        {
            System.out.println("File exists!");
        } else {
            System.out.println("File does NOT exist!");
        }
    }
}

//Cele 4 operații standard pe fișiere:
//Operație        Metodă
//
//Write           Files.write()
//Read            Files.readAllLines()
//Append          Files.write(..., APPEND)
//Exists check    Files.exists()
