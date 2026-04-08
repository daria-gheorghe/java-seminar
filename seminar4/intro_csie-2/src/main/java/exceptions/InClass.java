package exceptions;

public class InClass {
    public static void main(String[] args)
    {
//        În momentul în care o excepție este aruncată în interiorul blocului try, execuția:
//        1.	se oprește imediat în acel punct
//        2.	restul liniilor din try NU se mai execută
//        3.	programul sare direct în primul catch compatibil

        try{    //metoda este declarata static, deci se apaleaza cu 'NumeClasa.metoda()' si nu trebuie creat obiect
            InClass.validateAge(5); //sare in InvalidAgeException
            System.out.println("test");  //linia asta nu se executa pt ca apare exceptia
        }
        catch(InvalidAgeException e)
        {
            System.out.println("avem o exceptie");  //afiseaza mai intai mesajul asta
            System.out.println(e.getMessage()); //apoi mesajul pus de mine
        }
        finally
        {
            System.out.println("se executa intotdeauna");
        }
        System.out.println("dupa zona problematica");
    }

    public static void validateAge(int age) throws InvalidAgeException  //throws.. = metoda poate arunca aceasta exceptie
    {
        if (age<18){
            throw new InvalidAgeException("Age must be 18 or above");   //arunca exceptia definita mai jos de mine
        }
    }
}
//cand definesc eu o exceptie, trebuie sa ii fac o clasa, pt ca exceptiile sunt obiecte , iar obiectele provin din clase
class InvalidAgeException extends Exception //InvalidAgeException este o excepție nouă bazată pe Exception (clasa exceptiilor)
{
    public InvalidAgeException(String m){
        super(m);
    }
}
//Exception (clasa părinte) are deja un constructor: Exception(String message)
//care stocheaza mesajul erorii in obiectul exceptiei
//deci super(m) inseamna : apelează constructorul clasei părinte Exception și trimite mesajul m
// asa, pot face : e.getMessage() (in catch) si o sa imi returneze mesajul trimis de mine
//daca nu pun super(m) : mesajul nu ar fi salvat in exceptie, deci e.getMessage() ar returna null