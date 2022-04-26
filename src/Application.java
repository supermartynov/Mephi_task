import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static Library library;
    public static Scanner scanner = new Scanner(System.in);

    static {
        try {
            library = new Library();
        } catch (Exception err) {
            System.out.println(err.getCause());
        }
    }


    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Библиотека");
            System.out.println("1 Вывод книг");
            System.out.println("2 Редактирование книги");
            System.out.println("3 Добавление книги");
            System.out.println("4 Удаление книги");
            System.out.println("5 Выгрузка всех книг в файл");
            System.out.println("6 Загрузка книг из файла");

            Integer choice = scanner.nextInt();

            switch (choice) {
                case (1) :
                    library.printAll();
                    break;
                case (2) :
                    System.out.println("Измененная книга: " + Objects.requireNonNull(changeBookInterface()).toString());
                    break;
                case (3) :
                    System.out.println("Введите данные через пробел. Формат: Автор Имя Издательство Раздел Наличие Состояние");
                    String[] str = new Scanner(System.in).nextLine().trim().split(": ");
                    Integer count = library.bookList.size();
                    String author = str[0];
                    String name = str[1];
                    String izdat = str[2];
                    String razdel = str[3];
                    String nalichie = str[4];
                    String sost = str[5];
                    library.bookList.add(new Book(count, author, name, izdat, razdel, nalichie, sost));
                    break;
                case (4) :
                    library.printAll();
                    System.out.println("Введите номер книги для удаления");
                    library.bookList.remove(scanner.nextInt() - 1);
                    break;
                case (5) :
                    System.out.println("Данные загружены в файл");
                    library.writeInFile();
                case (6) :
                    library.readFromFile();
                    System.out.println("Данные выгружены из файла");
            }
        }
    }

    private static Book changeBookInterface() {
        library.printAll();
        System.out.println("Введите номер книги, которую хотите поменять");
        Integer choice = scanner.nextInt();
        if (library.bookList.size() <  choice || choice < 0) {
            System.out.println("Неверный индекс");
            return null;
        }
        System.out.println("Какой пункт хотите исправить, введите название пункта");
        System.out.println("Имя");
        System.out.println("Раздел");
        System.out.println("Издательство");
        System.out.println("Наличие");
        System.out.println("Состояние");
        String answer = scanner.nextLine();
        switch (new Scanner(System.in).nextLine()) {
            case ("Имя"):
                System.out.println("Введите новое имя");
                library.changeBookName(choice, scanner.nextLine());
                break;
            case ("Раздел"):
                System.out.println("Введите новый раздел");
                library.changeRazdel(choice, scanner.nextLine());
                break;
            case ("Издательство"):
                System.out.println("Введите новое издательство");
                library.changeIzdatelstvo(choice, scanner.nextLine());
                break;
            case ("Наличие"):
                System.out.println("Введите наличие : Да/Нет");
                library.changeBookNalichie(choice, scanner.nextLine());
                break;
            case ("Состояние"):
                System.out.println("Введите состояние");
                library.changeSostoinie(choice, scanner.nextLine());
                break;
        }
        return library.bookList.get(choice - 1);
    }
}
