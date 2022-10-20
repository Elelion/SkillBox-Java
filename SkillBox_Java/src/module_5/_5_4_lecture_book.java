package module_5;

// Задание 2
public class _5_4_lecture_book {
    private final String name;
    private final String author;
    private final int pagesCount;
    private final String ISBN;

    /**/

    public _5_4_lecture_book(String name, String author, int pagesCount, String ISBN) {
        this.name = name;
        this.author = author;
        this.pagesCount = pagesCount;
        this.ISBN = ISBN;
    }

    /**/

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public String getISBN() {
        return ISBN;
    }
}
