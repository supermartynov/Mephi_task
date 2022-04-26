import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> bookList;

    public Library() throws IOException {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "Л.Н.Толстой", "Война и мир 1 том", "Издательство АСТ", "Классическая проза", "Да", "Хорошее"));
        bookList.add(new Book(2, "Л.Н.Толстой", "Война и мир 2 том", "Издательство АСТ", "Классическая проза", "Да", "Хорошее"));
        bookList.add(new Book(3, "Л.Н.Толстой", "Война и мир 2 том", "Издательство АСТ", "Классическая проза", "Да", "Хорошее"));
        bookList.add(new Book(4, "Л.Н.Толстой", "Анна Каренина", "Издательство АСТ", "Драма", "Да", "Хорошее"));
    }

    public List<Book> getBookByAuthor(String author) throws FileNotFoundException {
        List<Book> authorsBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                authorsBooks.add(book);
            }
        }
        if (authorsBooks.isEmpty()) {
            System.out.println("Книг с таким автором нет");
            return null;
        }
        return authorsBooks;
    }

    public List<Book> getBookByRazdel(String razdel) throws FileNotFoundException {
        List<Book> razdelBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equals(razdel)) {
                razdelBooks.add(book);
            }
        }
        if (razdelBooks.isEmpty()) {
            System.out.println("Книг с таким разделом нет");
            return null;
        }
        return razdelBooks;
    }

    public List<Book> getBookByNalichie(String nalichie) throws FileNotFoundException {
        List<Book> nalichieBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equals(nalichie)) {
                nalichieBooks.add(book);
            }
        }
        if (nalichieBooks.isEmpty()) {
            System.out.println("Нет доступных книг");
            return null;
        }
        return nalichieBooks;
    }

    public Book changeBookName(Integer count, String name) {
        bookList.get(count - 1).setName(name);
        return bookList.get(count - 1);
    }

    public Book changeBookNalichie(Integer count, String nalichie) {
        bookList.get(count - 1).setNalichie(nalichie);
        return bookList.get(count - 1);
    }

    public Book changeAuthor(Integer count, String  author) {
        bookList.get(count - 1).setAuthor(author);
        return bookList.get(count - 1);
    }

    public Book changeIzdatelstvo(Integer count, String izdatelstvo) {
        bookList.get(count - 1).setIzdatelstvo(izdatelstvo);
        return bookList.get(count - 1);
    }

    public Book changeSostoinie(Integer count, String sostoinie) {
        bookList.get(count - 1).setSostoinie(sostoinie);
        return bookList.get(count - 1);
    }

    public Book changeRazdel(Integer count, String razdel) {
        bookList.get(count - 1).setRazdel(razdel);
        return bookList.get(count - 1);
    }

    public void writeInFile() throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("library.txt"));
        for (Book book : bookList) {
            fileWriter.write(book.toString() + "\n");
            fileWriter.flush();
        }
        fileWriter.close();
    }

    public void readFromFile() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("library.txt"));
        String line;
        bookList = new ArrayList<>();
        while ((line = fileReader.readLine()) != null) {
            String[] str = line.split(": ");
            System.out.println(line + "\n");
            Integer count = bookList.size();
            String author = str[1];
            String name = str[3];
            String izdat = str[5];
            String razdel = str[7];
            String nalichie = str[9];
            String sost = str[11];
            bookList.add(new Book(count, author, name, izdat, razdel, nalichie, sost));
        }
        fileReader.close();
    }

    public void printAll() {
        bookList.stream().forEach(System.out::println);
    }
}
