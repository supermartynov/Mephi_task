public class Book {
    private Integer Count;
    private String Author;
    private String Name;
    private String Izdatelstvo;
    private String Razdel;
    private String Nalichie;
    private String Sostoinie;

    public Book(Integer count, String author, String name, String izdatelstvo, String razdel, String nalichie, String sostoinie) {
        Count = count;
        Author = author;
        Name = name;
        Izdatelstvo = izdatelstvo;
        Razdel = razdel;
        Nalichie = nalichie;
        Sostoinie = sostoinie;
    }


    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIzdatelstvo() {
        return Izdatelstvo;
    }

    public void setIzdatelstvo(String izdatelstvo) {
        Izdatelstvo = izdatelstvo;
    }

    public String getRazdel() {
        return Razdel;
    }

    public void setRazdel(String razdel) {
        Razdel = razdel;
    }

    public String getNalichie() {
        return Nalichie;
    }

    public void setNalichie(String nalichie) {
        Nalichie = nalichie;
    }

    public String getSostoinie() {
        return Sostoinie;
    }

    public void setSostoinie(String sostoinie) {
        Sostoinie = sostoinie;
    }

    @Override
    public String toString() {
        return "Номер: " + Count +
                " Автор: " + Author + ' ' +
                " Имя: " + Name + ' ' +
                " Издательство: " + Izdatelstvo + ' ' +
                " Раздел: " + Razdel + ' ' +
                " Наличие: " + Nalichie + ' ' +
                " Состояние: " + Sostoinie;
    }
}
