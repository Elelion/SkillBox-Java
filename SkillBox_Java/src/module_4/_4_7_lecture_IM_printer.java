package module_4;

public class _4_7_lecture_IM_printer {
    private String queue = ""; // список документов на печать
    private int pagesInQueue; // документов в очереди
    private int printedPages; // документов распечатано

    public void append(String text, String name, int pagesCount) {
        queue += "\n" + name + " - " + text;
        pagesInQueue += pagesCount;
    }

    public void append(String text) {
        queue += "\n Документ без имени - " + text;
        pagesInQueue += 1;
    }

    public void append(String text, String name) {
        queue += "\n" + name + " - " + text;
        pagesInQueue += 1;
    }

    public void append(String text, int pagesCount) {
        queue += "\n Документ без имени - " + text;
        pagesInQueue += pagesCount;
    }

    /**/

    public void clear() {
        queue = "";
        pagesInQueue = 0;
    }

    public void print() {
        printedPages += pagesInQueue;
        System.out.println(queue);
        clear();
    }

    /**/

    public int getPendingPagesCount() {
        return pagesInQueue;
    }

    public int getPrintedPagesCount() {
        return printedPages;
    }
}
