public class Main
{
    public static void main(String[] args)
    {
        Books c1=new Books();    //obiect creat in memoria programului
        //obiectul de tip Books e salvat in heap, c1 este referinta catre el, salvata pe stack
        Books c2=new Books("ion","l.rebreanu",300);
        System.out.println(c2);
    }
}
//1.
//creeati o clasa Books
//adaugati 3 atribute
//creeati constructori
//creeati 2 obiecte, unul gol si unul cu 3 parametrii

//2.
//aplicati principiul de incapsulare pt clasa Books
//pt asta tre sa fac atributele private si apoi sa fac pt ele getteri si setteri

//mostenire:
//prin cuvantul: extends
//clasa parinte: atribute si metode
//clasa derivata: va mosteni atr+met de mai sus, putem adauga si altele
//putem sa suprascriem(supradefinim) metode din clasa parinte (@Override)
//'super': referinta catre constructorul clasei parinte, dar poate fi folosit si pt metode(folosesc cuvantul 'super' pt a apela si metoda din clasa parinte)
//orice clasa in java mosteneste clasa Object(by default)
//in java nu se accepta mostenire multipla(o clasa sa mosteneasca 2 sau mai multe clase)
//putem avea implementare de mai multe interfete: prin cuvantul 'implements'


//supradefinire vs supraincarcare
//am o metoda(cu un corp)
//supradefinire: signatura la fel, schimb corpul
//supraincarcare: acelasi nume, dar parametri diferiti

//'final'=nu mai poate fi modificat(atr)/suprascrisa(met)/nu pot fi definite clase derivate din ea(cls) ->acelasi lucru cu const de la POO