package module_13_features_of_OOP;

import module_13_features_of_OOP._13_14_practical_airport.Aircraft;
import module_13_features_of_OOP._13_14_practical_airport.Airport;
import module_13_features_of_OOP._13_14_practical_airport.Flight;
import module_13_features_of_OOP._13_14_practical_airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//import static net.sf.saxon.query.XQueryParser.stringify;
//import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class _13_practical_main {
    private static final List<Flight> expectedFlights = new ArrayList<>();
    private static final int HOUR = 3_600_000;
    private static final int THREE_HOURS = 10_800_000;
    private static final int HOUR_AND_HALF = 5_400_000;
    private static final String[] companyCodes = new String[]{"SU", "AA", "AR", "AF", "B2", "FV"};

    public static void main(String[] args) {
        System.out.println("Задание №1");

        Airport airport = Airport.getInstance();
        List<Terminal> terminals = generateRandomTerminals();
        airport.getTerminals().clear();
        airport.getTerminals().addAll(terminals);
        List<Flight> actualFlight = _13_practical_main.findPlanesLeavingInTheNextTwoHours(airport);

//        assertIterableEquals(expectedFlights, actualFlight,
//            String.join(", ", String.format("%nExpected:%s%n%nActual:%s%n%n",
//                expectedFlights,
//                actualFlight)
//            ));

        System.out.println("airport: " + airport);
        System.out.println("terminals: " + terminals);
        System.out.println("airport-stream: " + airport.getTerminals()
            .stream()
            .map(Terminal::getFlights));

        System.out.println("airport-stream+F+M: " + airport.getTerminals()
            .stream()
            .map(Terminal::getFlights).flatMap(List::stream));

        System.out.println("terminals.get: " + terminals
            .stream()
            .map(terminal -> terminal.getFlights().getClass()));

        System.out.println("airport-FULL: " + airport.getTerminals().stream()
            .map(Terminal::getFlights)
            .flatMap(List::stream)
            .filter(flight -> flight.getType() == Flight.Type.DEPARTURE
                && flight.getDate().getTime() > System.currentTimeMillis()
                && flight.getDate().getTime() < System.currentTimeMillis() + 7_200_000)
            .collect(Collectors.toList()));
    }

    /**/

    /**
     * метод для выполнения задания
     */
    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

        return (List<Flight>) airport.getTerminals().stream()
            .map(Terminal::getFlights)
            .flatMap(List::stream)
            .filter(flight -> flight.getType() == Flight.Type.DEPARTURE
                && flight.getDate().getTime() > System.currentTimeMillis()
                && flight.getDate().getTime() < System.currentTimeMillis() + 7_200_000)
            .collect(Collectors.toList());
    }

    /**/

    /**
     * ниже идут методы стянутые из тестов, что бы поработать с данными
     * которые содержуться в классах данные SkillBox
     */
    private static List<Terminal> generateRandomTerminals() {
        List<Terminal> terminals = new ArrayList<>();
        IntStream.range(0, 5).mapToObj(i -> new Terminal(UUID.randomUUID().toString()))
            .forEach(terminal -> {
                Flight expectedFlight1 = generateDepartureFlight(generateDate(HOUR));
                Flight expectedFlight2 = generateDepartureFlight(generateDate(HOUR_AND_HALF));
                terminal.addFlight(expectedFlight1);
                terminal.addFlight(expectedFlight2);
                terminal.addFlight(generateDepartureFlight(generateDate(THREE_HOURS)));
                terminal.addFlight(generateDepartureFlight(generateDate(THREE_HOURS)));
                terminal.addFlight(generateArrivalFlight(generateDate(HOUR)));
                terminal.addFlight(generateArrivalFlight(generateDate(HOUR_AND_HALF)));
                terminal.addFlight(generateArrivalFlight(generateDate(THREE_HOURS)));

                expectedFlights.add(expectedFlight1);
                expectedFlights.add(expectedFlight2);
                terminals.add(terminal);
            });
        return terminals;
    }

    private static Flight generateDepartureFlight(Date date) {
        return new Flight(getRandomString(), Flight.Type.DEPARTURE, date, generateAircraft());
    }

    private static String getRandomString() {
        return companyCodes[(int) (Math.random() * companyCodes.length)] + "-" + (int) (Math.random() * 1000 + 1000);
    }

    private static Flight generateArrivalFlight(Date date) {
        return new Flight(getRandomString(), Flight.Type.ARRIVAL, date, generateAircraft());
    }

    private static Date generateDate(int hours) {
        return new Date(System.currentTimeMillis() + hours);
    }

    private static Aircraft generateAircraft() {
        return new Aircraft(getRandomString());
    }
}
