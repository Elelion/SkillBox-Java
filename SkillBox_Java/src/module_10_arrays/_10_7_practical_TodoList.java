package module_10_arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class _10_7_practical_TodoList {
    private static final String LIST = "LIST";
    private static final String ADD = "ADD";
    private static final String EDIT = "EDIT";
    private static final String DELETE = "DELETE";

    private ArrayList<String> todoList = new ArrayList<>();
    private int index = 0;
    private String[] elementsText;

    public _10_7_practical_TodoList() {
        /**
         * TODO: Задание 10.7
         * Цель задания
         * • Научиться работать со списком ArrayList.
         *
         * Что нужно сделать
         * - Задание выполняйте в проекте 09_ArraysAndCollections/>homework_9.2/TodoList.
         * - Разработайте программу — список дел, который управляется
         * командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
         * - Для работы с данными списка дел в проекте находится класс TodoList,
         * который должен отвечать за хранение и работу со списком дел. Реализуйте
         * все методы и проверьте класс с помощью существующих тестов.
         * - В классе Main напишите код для реализации взаимодействия с
         * пользователем через ввод команд в консоль.
         *
         * Принцип работы команд:
         * • LIST — выводит дела с их порядковыми номерами;
         * • ADD — добавляет дело в конец списка или дело на определённое место,
         * сдвигая остальные дела вперёд, если указать номер; если указан
         * несуществующий индекс - добавить в конец списка.
         * • EDIT — заменяет дело с указанным номером; если указан несуществующий
         * индекс - ничего не делать.
         * • DELETE — удаляет; если указан несуществующий индекс - ничего не делать.
         *
         * - Команды вводятся пользователем в консоль одной строкой.
         *
         * Примеры работы со списком дел (жирным шрифтом выделен ввод пользователя)
         * • ADD buy milk
         * Добавлено дело "buy milk"
         *
         * • ADD learn java
         * Добавлено дело "learn java"
         *
         * • LIST
         * 0 - buy milk
         * 1 - learn java
         *
         * • EDIT 0 make a cup of tea
         * Дело "buy milk" заменено на "make a cup of tea"
         *
         * • DELETE 1
         * Дело "learn java" удалено
         *
         * • LIST
         * 0 - make a cup of tea
         *
         * • DELETE 100
         * Дело с таким номером не существует
         */

        while (true) {
            String text = new Scanner(System.in).nextLine();

            elementsText = text.split(" ");
            String command = elementsText[0];

            // проверяем указал ли пользователь индекс для команды или нет
            if (elementsText.length > 1) {
                index = (elementsText[1].matches("\\d++")) ? 2 : 1;
            }

            /**
             * - сздаем строку, которая будет содержать введенный текст без мусора
             * - склеиваем обратно нашу строку, НО уже без команды и индекса
             */
            StringBuilder textWithoutCommand = new StringBuilder();
            for (int i = index; i <= elementsText.length - 1; i++) {
                textWithoutCommand.append(elementsText[i]).append(' ');
            }

            /**
             * - получаем индекс команды, если пользователь указал его
             * - затем сбрасываем index, что бы не возникало ошибок, когда мы
             * указываем команду без индекса
             */
            int indexForSelect = (index == 2) ? Integer.parseInt(elementsText[1]) : 0;
            index = 1;

            actions(command, indexForSelect, textWithoutCommand);
            System.out.println(todoList);
        }
    }

    private void actions(String command, int indexForSelect, StringBuilder textWithoutCommand) {
        switch (command) {
            case ADD:
                if (index == 2) {
                    add(indexForSelect, textWithoutCommand.toString());
                } else {
                    add(textWithoutCommand.toString());
                }
                break;

            case LIST:
                for (int i = 0; i <= todoList.size() - 1; i++) {
                    System.out.println(i + " - " + todoList.get(i));
                }
                break;

            case EDIT:
                edit(indexForSelect, textWithoutCommand.toString());
                break;

            case DELETE:
                delete(indexForSelect);
                break;

            default:
                break;
        }
    }

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка

         todoList.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления

//        if (index < todoList.size() - 1) {
            todoList.add(index, todo);
//        }
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

        if (index < todoList.size() - 1) {
            // todoList.set(index, todo);
            todoList.set(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела

        if (index <= todoList.size() - 1) {
            todoList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел

        return todoList;
    }
}
