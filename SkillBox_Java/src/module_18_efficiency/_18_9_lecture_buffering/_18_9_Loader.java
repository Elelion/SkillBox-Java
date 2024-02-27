package module_18_efficiency._18_9_lecture_buffering;

import module_18_efficiency._18_11_lecture_fewer_requests.Voter;
import module_18_efficiency._18_11_lecture_fewer_requests.WorkTime;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class _18_9_Loader {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, module_18_efficiency._18_11_lecture_fewer_requests.WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<module_18_efficiency._18_11_lecture_fewer_requests.Voter, Integer> voterCounts = new HashMap<>();

    private static String pathProject = "SkillBox_Java" + File.separator + "src";
    private static String pathRootDir = "module_18_efficiency";
    private static String pathLectureDir = "";
    private final static String FILENAME =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "res" + File.separator + "data-18M.xml";

    public static void main(String[] args) throws Exception {
        // вынесли все в beginEvents, что бы запустить все из _18_main.java
        _18_11_beginEvents();
    }

    /**/

    public static void _18_11_beginEvents() throws Exception {
        String fileName = FILENAME;

        /**
         * убираем наш старый механизм парсинга файлов
         */

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // наш созданный класс!!!
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        handler.printDuplicatedVoters();

    }

    private static void parseFile(String fileName) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));

        findEqualVoters(doc);
        fixWorkTimes(doc);
    }

    private static void findEqualVoters(Document doc) throws Exception {
        NodeList voters = doc.getElementsByTagName("voter");
        int votersCount = voters.getLength();
        for (int i = 0; i < votersCount; i++) {
            Node node = voters.item(i);
            NamedNodeMap attributes = node.getAttributes();

            String name = attributes.getNamedItem("name").getNodeValue();
            Date birthDay = birthDayFormat
                .parse(attributes.getNamedItem("birthDay").getNodeValue());

            module_18_efficiency._18_11_lecture_fewer_requests.Voter voter = new Voter(name, birthDay);
            Integer count = voterCounts.get(voter);
            voterCounts.put(voter, count == null ? 1 : count + 1);
        }
    }

    private static void fixWorkTimes(Document doc) throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();
        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();

            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            module_18_efficiency._18_11_lecture_fewer_requests.WorkTime workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }
}
