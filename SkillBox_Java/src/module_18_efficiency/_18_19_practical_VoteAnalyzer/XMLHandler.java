package module_18_efficiency._18_19_practical_VoteAnalyzer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private boolean EoS = false;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");

    /**
     * наш код будет обрабатываться последовательно, и каждый раз при выполнении
     * условий эта переменная будет накапливать в себе некий объем данных
     * если мы запустим файл на 1+gb и ограничем ОЗУ для VM то будет ошибка
     *
     * и в этих случаях целесообразнее записывать эти данные в БД а не в переменную
     */
    private HashMap<Voter, Integer> voterCounts;

    public XMLHandler() {
        this.voterCounts = new HashMap<>();
    }

    /**
     * срабатывает когда парсер натыкается на какой либо документ
     * когда встречается на путикакой то тег, то наш класс сразу же вызывает
     * метод startElement
     *
     * когда тег заканчивается, то класс вызывает метод endElement
     *
     * qName - имя тега
     * attributes - атрибут тега (name, birthDay,... итп)
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        EoS = false;

        try {
            if (qName.equals("voter") && voter == null) {
                Date birthday = birthDayFormat.parse(attributes.getValue("birthDay"));

                // присваиваем запись типа - Просвиркин Авдий (1959.09.06)
                voter = new Voter(attributes.getValue("name"), birthday);

                // System.out.println(qName + " - start");
            } else if (qName.equals("visit") && voter != null) {
                /**
                 * будем складывать voter, каждый раз когда встречается visit
                 * те самый первый раз будет 0, тк значение встретиться в первые
                 * потом, если значение встретиться еще раз то вторым значением
                 * будет уже 0+1 итп
                 */
                int count = voterCounts.getOrDefault(voter, 0);
                voterCounts.put(voter, count + 1);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);

        if (qName.equals("voter")) {

            // стираем
            voter = null;
        }

//         System.out.println(qName + " - end");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        /**
         * Устанавливаем флаг, когда обработка документа завершена
         */
        EoS = true;
    }

    public boolean isEndOfStream() {
        return EoS;
    }

    public void printDuplicatedVoters() {

        /**
         * ключами объявляются объекты класса Voter
         * тк выше мы присваиваем
         * voter = new Voter(attributes.getValue("name"), birthday);
         * те в voter будет - Чернопуп Куприян (1966.02.20)
         *
         * а далее пихаем voter в виде ключа в переменную voterCounts
         * voterCounts.put(voter, count + 1);
         *
         * Разберем: int count = voterCounts.get(voter);
         * Когда мы вызываем метод voterCounts.get(voter), мы передаем
         * ключ - объект voter - и получаем соответствующее ему
         * значение - количество посещений данного избирателя. Если данный
         * избиратель еще не был добавлен в HashMap, метод get() вернет
         * значение по умолчанию - 0.
         */
        for (Voter voter : voterCounts.keySet()) {
            int count = voterCounts.get(voter);
//
            if (count > 1) {
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }

    public void printRes() {
        int x = 0;

        for (Voter voter : voterCounts.keySet()) {
            System.out.println(voter.getName() + " + " + voter.getBirthDay() + " - №: " + x);
            x++;
        }
    }

    public HashMap<Voter, Integer> getVoterCounts() {
        return voterCounts;
    }
}
