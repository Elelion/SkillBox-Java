package module_18_efficiency._18_19_practical_VoteAnalyzer;

import module_18_efficiency._18_19_practical_VoteAnalyzer.DBConnection;
import module_18_efficiency._18_19_practical_VoteAnalyzer.Voter;
import module_18_efficiency._18_19_practical_VoteAnalyzer.WorkTime;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Loader {
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    private static String pathProject = "SkillBox_Java" + File.separator + "src";
    private static String pathRootDir = "module_18_efficiency";
    private static String pathLectureDir = "";
    private final static String FILENAME =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "res" + File.separator + "data-1572M.xml";
//            + "res" + File.separator + "data-18M.xml";

    /**/

    /**
     * шаг = 1_000 = 903 381 мс (~15 мин)
     * шаг = 100_000 = 269 174 мс (~4 мин)
     */
    public Loader() throws Exception {
        String fileName = FILENAME;
        long start = System.currentTimeMillis();

        /**/

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);

        voterCounts = handler.getVoterCounts();

        for (Voter voter : voterCounts.keySet()) {
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            String formattedDate = outputDateFormat.format(voter.getBirthDay());

            /**
             * Кладем данные в StringBuilder, где каждые BATCH_SIZE шагов
             * записываем данные в БД
             *
             * Методы носят названия из лекций, что бы мне потом было легче
             * орентироваться.
             *
             * В данном случае было бы логичным назвать его:
             * putData, writeString, addStringInStringBuilderAndWriteInDB,
             * writeData, stepWriteToDB, итп...
             */
             DBConnection.countVoter(voter.getName(), formattedDate);
        }

        /**
         * Дописываем все что осталось в String Builder
         *
         * Без этой записи было 12_344_765 строк
         * С записью стало 12_348_949 строк
         */
        if (handler.isEndOfStream()) {
            DBConnection.executeMultiInsert();
        }


        /**/

        System.out.println("Время выполнения: " +
            (System.currentTimeMillis() - start) + " мс");
        System.out.println(System.lineSeparator());
    }

    /* ----------------------------------------------------------------- */

    /**
     * TODO: ReadMe
     *
     * ниже идут не зайдествованные методы, которые оставлены лишь для примера
     * в целях моего обучения
     */

    /**
     * Старый вариант записи, оставили для примера
     * НЕ работает с большим объемом данных
     */
    private void _parseFile(String fileName) throws Exception {

        /**
         * DocumentBuilderFactory - это класс, который предоставляет статические
         * методы для создания экземпляров DocumentBuilder. DocumentBuilderFactory
         * используется для создания парсера, который может анализировать
         * XML-документы и создавать объекты org.w3c.dom.Document. Этот класс
         * предоставляет различные настройки для создания DocumentBuilder,
         * такие как установка свойств, контроль за анализом, выбор реализации
         * XML и т.д.
         *
         * Класс DocumentBuilderFactory - это один из способов получения
         * экземпляра DocumentBuilder, который является основным классом
         * для работы с XML в Java.
         *
         * Здесь метод newInstance() возвращает экземпляр DocumentBuilderFactory
         */
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        /**
         * DocumentBuilder - это интерфейс, который предоставляет методы
         * для создания объекта Document, который может быть использован для
         * чтения, создания и изменения документов XML. Объект DocumentBuilder
         * создает Document на основе входных данных, таких как XML-файл,
         * поток ввода или источник ввода.
         */
        DocumentBuilder db = dbf.newDocumentBuilder();

        /**
         * Метод parse в классе DocumentBuilder используется для чтения
         * XML-документа из источника данных и создания объекта
         * org.w3c.dom.Document, который представляет дерево элементов
         * XML-документа.
         *
         * Когда метод parse вызывается, он анализирует содержимое
         * XML-файла и возвращает объект Document, который можно
         * использовать для доступа к элементам документа. Если файл
         * содержит ошибки, parse может выбросить SAXException.
         */
        Document doc = db.parse(new File(fileName));

//        findEqualVoters(doc);
    }

    /**
     * Оставили для примера
     */
    private void _findEqualVoters(Document doc) throws Exception {

        /**
         * Получение списка всех узлов-потомков элемента/тега voter
         *
         * NodeList - это интерфейс в Java, определяющий список узлов XML-документа.
         * Он является частью DOM (Document Object Model) API, который представляет
         * собой стандартный способ доступа к XML-документам.
         *
         * NodeList представляет коллекцию узлов в порядке, в котором они
         * появляются в документе. Этот интерфейс определяет набор методов
         * для доступа к отдельным узлам списка, а также к их количеству.
         * Например, можно получить узел по его индексу в списке с помощью
         * метода item(), а также узнать количество узлов в списке с помощью
         * метода getLength().
         *
         * NodeList используется для обхода дерева XML-документа, чтобы извлечь
         * или изменить его содержимое. Он может быть получен из элемента
         * Document с помощью метода getElementsByTagName(), который
         * возвращает список узлов, соответствующих заданному имени тега.
         * Метод getChildNodes() элемента Node также возвращает список узлов-детей.
         */
        NodeList voters = doc.getElementsByTagName("voter");
        int votersCount = voters.getLength();

        for (int i = 0; i < votersCount; i++) {

            /**
             * Node является базовым интерфейсом для других интерфейсов, таких
             * как Element, Text, Attribute, Comment, Document, DocumentType и
             * других, которые представляют соответствующие узлы DOM. Каждый
             * узел может иметь дочерние элементы, атрибуты и т.д.
             */
            Node node = voters.item(i);

            /**
             * NamedNodeMap - это интерфейс в Java, который представляет коллекцию
             * узлов, которые являются элементами узла, содержащего атрибуты. Этот
             * интерфейс предоставляет доступ к атрибутам элемента узла, которые
             * хранятся в NamedNodeMap.
             *
             * NamedNodeMap имеет несколько методов, включая
             * getNamedItem, setNamedItem и removeNamedItem, которые позволяют
             * получать, устанавливать и удалять атрибуты элемента
             * узла из NamedNodeMap.
             */
            NamedNodeMap attributes = node.getAttributes();

            /**
             * извлекаем данные из распарсенного XML
             */
            String name = attributes.getNamedItem("name").getNodeValue();

//            Date birthDay = birthDayFormat
//                .parse(attributes.getNamedItem("birthDay").getNodeValue());

            String birthDay = attributes.getNamedItem("birthDay").getNodeValue();

            // будем добавлять изберателей в БД
//            Voter voter = new Voter(name, birthDay);
//            Integer count = voterCounts.get(voter);
//            voterCounts.put(voter, count == null ? 1 : count + 1);

            // Казимов Фалалей - 1975.04.03
//            System.out.println(name + " - " + birthDay);

            DBConnection.countVoter(name, birthDay);
        }

        // вызываем обязательно после цикла, тк в цикле мы наполняем наш insertQuery
        DBConnection.executeMultiInsert();
    }

    /**
     * Оставили для примера
     */
    private void _fixWorkTimes(Document doc) throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();

        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();

            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            WorkTime workTime = voteStationWorkTimes.get(station);

            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }

            workTime.addVisitTime(time.getTime());
        }
    }

}
