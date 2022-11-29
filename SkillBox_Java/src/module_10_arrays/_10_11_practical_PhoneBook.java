package module_10_arrays;

import module_3.CatColor_enum_3_5;

import java.util.*;

public class _10_11_practical_PhoneBook {

    private final String SUCCESS = "SUCCESS";
    private final String NAME_EXISTS = "NAME_EXISTS";
    private final String PHONE_EXISTS = "PHONE_EXISTS";
    private final String PHONE_NOT_EXISTS = "PHONE_NOT_EXISTS";
    private final String INVALID_FORMAT = "INVALID_FORMAT";
    private final String NEW_SINGLE_PHONE = "NEW_SINGLE_PHONE";
    private final String NEW_SINGLE_NAME = "NEW_SINGLE_NAME";

    private final String regexNameCheck = "[a-zA-Zа-яА-Я]{1,20}";
    private final String regexPhoneCheck = "\\d{11}";
    private final HashMap<String, String> phoneBook = new HashMap<>();

    private String[] elementsText;

    /**/

    public _10_11_practical_PhoneBook() {
        /**
         * TODO: Задание 10.11
         * - Напишите программу, которая будет работать как телефонная книга:
         * • Если вводим новое имя, программа просит ввести номер телефона и
         * запоминает его.
         * • Если новый номер телефона — просит ввести имя и также запоминает.
         * • Если вводим существующее имя или номер телефона, программа выводит
         * телефон(ы) или имя абонента соответственно.
         * • При вводе команды LIST программа печатает в консоль список всех
         * абонентов в алфавитном порядке с номерами.
         *
         * - Определяйте имя и телефон с помощью регулярных выражений.
         * - Подумайте, что выбрать в качестве ключа и значения для Map, и
         * выберите лучший, по вашему мнению, вариант. Опишите, какие минусы
         * и плюсы видите в своём выборе.
         * - Для работы с данными телефонной книги в проекте находится класс
         * PhoneBook, который должен отвечать за хранение и работу с абонентами.
         * Реализуйте все методы и проверьте класс с помощью существующих тестов.
         * Вы можете добавлять дополнительные методы в класс.
         * - Команды вводятся пользователем в консоль одной строкой.
         *
         * Примеры работы с телефонной книгой (жирным шрифтом выделен ввод пользователя)
         * • Введите номер, имя или команду:
         * • Маша
         * • Такого имени в телефонной книге нет.
         * • Введите номер телефона для абонента “Маша”:
         * • 79001234567
         * • Контакт сохранен!
         *
         * • Введите номер, имя или команду:
         * • 79007654321
         * • Такого номера нет в телефонной книге.
         * • Введите имя абонента для номера “79007654321”:
         * • Маша
         * • Контакт сохранен!
         *
         * • Введите номер, имя или команду:
         * • Nfif@
         * • Неверный формат ввода
         *
         * • Введите номер, имя или команду:
         * • LIST
         * • Маша - 79001234567, 79007654321
         */

        /**
         * Передан неверный формат телефонного номера
         * 79001234567 79001234567
         *
         * Передано пустая строка в Имени абонента
         * 79991234567
         *
         * Передано пустая строка в телефоне абонента
         *  Маша
         *
         * Передан неверный формат телефонного номера
         * Маша Маша
         *
         * Добавление контактов с одинаковым номером, владелец должен быть перезаписан
         * 79001234567 Маша
         * 79001234567 Миша
         *
         * Корректное добавление контакта
         * 79001234567 Маша
         * 79991234567 Миша
         *
         * Добавление контакта, владеющий двумя номерами
         * 79001234567 Маша
         * 79007654321 Маша
         */

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String userInputText = new Scanner(System.in).nextLine();
            elementsText = userInputText.split(" ");

            String name = "";
            String phone = "";

            if (elementsText.length > 1) {
                phone = elementsText[0];
                name = elementsText[1];
            }

            if (userInputText.equals("LIST")) {
                System.out.println(getAllContacts());
                System.out.println(System.lineSeparator());
            } else {
                if (elementsText.length <= 1) {
                    addContact(userInputText);
                } else {
                    addContact(phone, name);
                }
            }
        }
    }

    /**/

    public void addContact(String userInputText) {
        if (userInputText.matches(regexNameCheck)) {
            addContactSingleName(userInputText);
        } else if (userInputText.matches(regexPhoneCheck)) {
            addContactSinglePhone(userInputText);
        }

        checkTextValidate(userInputText);
    }

    /**
     * проверьте корректность формата имени и телефона
     * (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
     * если такой номер уже есть в списке, то перезаписать имя абонента
     */
    public void addContact(String phone, String name) {
        if (checkTextValidate(phone, name)) {
            if (phoneBook.isEmpty()) {
                printAlertMessages(PHONE_NOT_EXISTS, phone);
                System.out.println("Имя: " + name);

                phoneBook.put(name, phone);
                printAlertMessages(SUCCESS, null);
            } else {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    String key = entry.getKey(); // получения ключа
                    String value = entry.getValue(); // получения ключа
                    System.out.println(value);

                    addContactFullParam(name, phone, key, value);
                }
            }
        }
    }

    /**/

    private boolean checkTextValidate(String userInputText) {
        if (!userInputText.matches(regexNameCheck) && !userInputText.matches(regexPhoneCheck)) {
            printAlertMessages(INVALID_FORMAT, null);

            return false;
        }

        return true;
    }

    private boolean checkTextValidate(String phone, String name) {
        if (!name.matches(regexNameCheck) || !phone.matches(regexPhoneCheck)) {
            printAlertMessages(INVALID_FORMAT, null);

            return false;
        }

        return true;
    }

    /**/

    /**
     * для добавления ТОЛЬКО ИМЕНИ в методе addContact, что имеет ТОЛЬКО
     * один параметр
     */
    private void addContactSingleName(String userInputText) {
        if (phoneBook.containsKey(userInputText)) {
            System.out.println(getContactByName(userInputText));
            printAlertMessages(NAME_EXISTS, null);
        } else {
            printAlertMessages(NEW_SINGLE_NAME, userInputText);
            String userInputPhone = new Scanner(System.in).nextLine();

            if (userInputPhone.matches(regexPhoneCheck)) {
                phoneBook.put(userInputText, userInputPhone);
                printAlertMessages(SUCCESS, null);
            } else {
                System.out.println("Не верно введен телефон");
            }
        }
    }

    /**
     * для добавления ТОЛЬКО НОМЕРА ТЕЛЕФОНА в методе addContact, что
     * имеет ТОЛЬКО один параметр
     */
    private void addContactSinglePhone(String userInputText) {
        if (phoneBook.containsValue(userInputText)) {
            System.out.println(getContactByPhone(userInputText));
            printAlertMessages(PHONE_EXISTS, null);
        }

        if (phoneBook.isEmpty() || !phoneBook.containsValue(userInputText)) {
            printAlertMessages(NEW_SINGLE_PHONE, userInputText);
            String userInputName = new Scanner(System.in).nextLine();

            if (phoneBook.isEmpty()) {
                phoneBook.put(userInputName, userInputText);
            } else {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    String key = entry.getKey(); // получения ключа
                    String value = entry.getValue(); // получения значения

                    if (key.equals(userInputName)) {
                        phoneBook.put(key, value + ", " + userInputText);
                    } else {
                        phoneBook.put(userInputName, userInputText);
                    }
                }
            }

            printAlertMessages(SUCCESS, null);
        }
    }

    /**
     * для добавления НОМЕРА ТЕЛЕФОНА и ИМЕНИ в методе addContact, что
     * имеет ОБА необходимых параметра для добавления
     */
    private void addContactFullParam(String name, String phone, String key, String value) {
        if (phoneBook.containsValue(phone)) {
            System.out.println("Такой номер уже есть, имя: " + key);
            phoneBook.put(name, phone);
            phoneBook.remove(key);
            System.out.println("Владелец перезаписан на: " + name);
        } else {
            printAlertMessages(PHONE_NOT_EXISTS, phone);

            if (key.equals(name)) {
                phoneBook.put(name, value + ", " + phone);
            } else {
                phoneBook.put(name, phone);
            }

            printAlertMessages(SUCCESS, null);
        }
    }

    /**/

    /**
     * формат одного контакта "Имя - Телефон"
     * если контакт не найдены - вернуть пустую строку
     */
    public String getContactByPhone(String phone) {
        String phoneNumber = "";

        if (phoneBook.isEmpty()) {
            return phoneNumber;
        }

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value.equals(phone)) {
                phoneNumber = key + " - " + value;
            }
        }

        return phoneNumber;
    }

    /**
     * формат одного контакта "Имя - Телефон"
     * если контакт не найден - вернуть пустой TreeSet
     */
    public Set<String> getContactByName(String name) {
        Set<String> contact = new TreeSet<>();

        if (phoneBook.isEmpty()) {
            return contact;
        }

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения значения

            if (key.equals(name)) {
                String info = "";
                info = info.concat(key).concat(" - ").concat(value);
                contact.add(info);
            }
        }

        return contact;
    }

    /**
     * формат одного контакта "Имя - Телефон"
     * если контактов нет в телефонной книге - вернуть пустой TreeSet
     */
    public Set<String> getAllContacts() {
        TreeSet<String> allContacts = new TreeSet<>();

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения значения

            allContacts.add(key + " - " + value);
        }

        return allContacts;
    }

    /**/

    private void printAlertMessages(String command, String userInputText) {
        switch (command) {
            case SUCCESS:
                System.out.println("Контакт сохранен!");
                System.out.println(System.lineSeparator());
                break;

            case NAME_EXISTS:
                System.out.println("Err: " + NAME_EXISTS + " - Такое имя уже есть, введите другое.");
                System.out.println(System.lineSeparator());
                break;

            case PHONE_EXISTS:
                System.out.println("Err: " + PHONE_EXISTS + " - Такой номер уже есть, введите другой.");
                System.out.println(System.lineSeparator());
                break;

            case PHONE_NOT_EXISTS:
                System.out.println("Такого номера нет в телефонной книге.");
                System.out.println("Номер: " + userInputText);
                break;

            case INVALID_FORMAT:
                System.out.println("Err: " + INVALID_FORMAT + " - Неверный формат ввода");
                System.out.println(System.lineSeparator());
                break;

            case NEW_SINGLE_PHONE:
                System.out.println("Такого номера нет в телефонной книге.");
                System.out.println("Введите имя для “" + userInputText + "”:");
                break;

            case NEW_SINGLE_NAME:
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента “" + userInputText + "”:");
                break;

        }
    }
}
