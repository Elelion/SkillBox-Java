package module_4_objects_and_classes_Part_1;

// отделяем main от нашего основного класса basket
public class _4_7_lecture_IM_main {
    public static void main(String[] args) {
        /**
         * Java сам подставит нужный перегруженный метод там где это потребуется
         * пример см ниже
         */

        _4_7_lecture_IM_printer printer = new _4_7_lecture_IM_printer();
        printer.append("some text 133", "Справка");
        printer.append("some text 210", 544);
        System.out.println("В очереди: " + printer.getPendingPagesCount() + " стр.");
        printer.print();
        System.out.println("---");

        printer.append("some text 8", 530);
        printer.clear();
        System.out.println("---");

        printer.append("some text 23", "Договор", 312);
        printer.append("some text 11");
        printer.print();
        System.out.println("---");

        System.out.println("\n Распечатано: " + printer.getPrintedPagesCount() + " стр.");
    }
}
