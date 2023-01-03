package module_14_exceptions_debug_test_log._14_9_2_practical_RouteCalculator;

import junit.framework.TestCase;
import module_14_exceptions_debug_test_log._14_9_2_practical_RouteCalculator.core.Line;
import module_14_exceptions_debug_test_log._14_9_2_practical_RouteCalculator.core.Station;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> routeLesson, route, route1, route2;


    /**
     * метод позволяющий инициализировать некоторые данные
     */
    @Override
    protected void setUp() throws Exception {
        routeLesson = new ArrayList<>();

        Line lineLesson1 = new Line(1, "Первая");
        Line lineLesson2 = new Line(2, "Вторая");

        routeLesson.add(new Station("Арбузная", lineLesson1));
        routeLesson.add(new Station("Персиковая", lineLesson1));
        routeLesson.add(new Station("Яблочная", lineLesson2));
        routeLesson.add(new Station("Грушевка", lineLesson2));

        /**/

        route = new ArrayList<>();
        route1 = new ArrayList<>();
        route2 = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        route.add(new Station("Девяткино", line1));
        route.add(new Station("Автово", line1));

        route1.add(new Station("Девяткино", line1));
        route1.add(new Station("Озерки", line2));

        route2.add(new Station("Девяткино", line1));
        route2.add(new Station("Приморская", line2));

//        route.add(new Station("Петровская", line));
//        route.add(new Station("Петровская", line));
    }

    /**/

    /**
     * название обязательно должно ийдти с test
     */
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(routeLesson);
        double expected = 8.5;
        assertEquals(expected, actual);

    }

    public void testCalculateDurationZeroPass() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 12.5;
        assertEquals(expected, actual);

    }

    public void testCalculateDurationFirstPass() {
        double actual = RouteCalculator.calculateDuration(route1);
        double expected = 13.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationSecondPass() {
        double actual = RouteCalculator.calculateDuration(route2);
        double expected = 13.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {
        RouteCalculator routeCalculator = new RouteCalculator(new StationIndex());
        List<Station> actual1 = routeCalculator.getShortestRoute(routeLesson.get(0), routeLesson.get(3));
        List<Station> expected = routeLesson;
        assertEquals(expected, actual1);
    }

    /**/

    /**
     * метод который может удалять данные после проведения тестов
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
