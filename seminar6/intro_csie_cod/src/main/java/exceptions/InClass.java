package exceptions;

public class InClass {
    public static void main(String[] args) {

        try{
            InClass.validateAge(5);
            System.out.println("test");
        }catch(InvalidAgeException e) {
            System.out.println("avem o exceptie");
            System.out.println(e.getMessage());
        }finally{
            System.out.println("se executa intotdeauna");
        }
        System.out.println("dupa zona problematica");
    }
    public static void validateAge(int age) throws InvalidAgeException {
        if (age<18){
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
}
class InvalidAgeException extends Exception{
    public InvalidAgeException(String m){
        super(m);
    }
}