public class Books
{
    private String titlu;
    private String autor;
    private int nrPagini;

    public Books(){};
    public Books(String titlu,String autor,int nr)
    {
        this.titlu=titlu;
        this.autor=autor;
        this.nrPagini=nr;
    }

    public String getTitlu() { return titlu; }
    public String getAutor() { return autor; }
    public int getPagini() { return nrPagini; }

    public void setTitlu(String titlu) { this.titlu = titlu; }
    public void setAutor(String autor) { this.autor = autor;}
    public void setPagini(int pagini) { this.nrPagini = pagini; }

    @Override
    public String toString()    //aceasta metoda vine din clasa Object, o generezi automat
    {                           //o folosesc ca sa vad continutul unui obiect, altfel as vedea doar adresa obiectului
        return "Books{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", nrPagini=" + nrPagini +
                '}';
    }
}
