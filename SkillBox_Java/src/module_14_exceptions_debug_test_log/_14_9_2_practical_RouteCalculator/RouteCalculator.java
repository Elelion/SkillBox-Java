package module_14_exceptions_debug_test_log._14_9_2_practical_RouteCalculator;

import module_14_exceptions_debug_test_log._14_9_2_practical_RouteCalculator.core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RouteCalculator {
    private final StationIndex stationIndex;

    private static final double INTER_STATION_DURATION = 2.5;
    private static final double INTER_CONNECTION_DURATION = 3.5;

    public RouteCalculator(StationIndex stationIndex) {
        this.stationIndex = stationIndex;
    }

    public List<Station> getShortestRoute(Station from, Station to) {
        List<Station> route = getRouteOnTheLine(from, to);
        if (route != null) {
            return route;
        }

        /**
         * TODO
         * В случае маршрута с двумя пересадками здесь будет не null,
         * а пустой список, что и приводит к ошибке.
         *
         * чтобы всё работало, в нём должна быть проверка на null
         *
         * если с одной пересадкой не выходит, то метод возвращает пустой лист,
         * но не null. Поэтому в поиск с двумя пересадками программа
         * вообще не заходит
         */

        route = getRouteWithOneConnection(from, to);
        // было так
        /*
        if (route != null) {
            System.out.println("-> Маршрут с одной пересадкой.");
            return route;
        }
        */

        // FIXME: проверить тут - исправил тут, вроде работает как надо
        if (route.size()==0) {
            System.out.println("-> Маршрут с одной пересадкой.");
            return null;
        }

        // FIXME: проверить тут - ну или так вроде то же работает
        /*
        if (route != null && route.size() > 0) {
            System.out.println("-> Маршрут с одной пересадкой.");
            return route;
        }
        */

        route = getRouteWithTwoConnections(from, to);
        return route;
    }

    public static double calculateDuration(List<Station> route) {
        double duration = 0;
        Station previousStation = null;

        for (int i = 0; i < route.size(); i++) {
            Station station = route.get(i);

            if (i > 0) {
                duration += previousStation.getLine().equals(station.getLine()) ?
                    INTER_STATION_DURATION : INTER_CONNECTION_DURATION;
            }

            previousStation = station;
        }

        return duration;
    }

    private List<Station> getRouteOnTheLine(Station from, Station to) {
        if (!from.getLine().equals(to.getLine())) {
            return null;
        }

        List<Station> route = new ArrayList<>();
        List<Station> stations = from.getLine().getStations();
        int direction = 0;

        for (Station station : stations) {
            if (direction == 0) {
                if (station.equals(from)) {
                    direction = 1;
                } else if (station.equals(to)) {
                    direction = -1;
                }
            }

            if (direction != 0) {
                route.add(station);
            }

            if ((direction == 1 && station.equals(to)) ||
                (direction == -1 && station.equals(from))) {
                break;
            }
        }
        if (direction == -1) {
            Collections.reverse(route);
        }
        return route;
    }

    private List<Station> getRouteWithOneConnection(Station from, Station to) {
        if (from.getLine().equals(to.getLine())) {
            return null;
        }

        List<Station> route = new ArrayList<>();

        List<Station> fromLineStations = from.getLine().getStations();
        List<Station> toLineStations = to.getLine().getStations();

        for (Station srcStation : fromLineStations) {
            for (Station dstStation : toLineStations) {
                if (isConnected(srcStation, dstStation)) {
                    ArrayList<Station> way = new ArrayList<>();
                    way.addAll(getRouteOnTheLine(from, srcStation));
                    way.addAll(getRouteOnTheLine(dstStation, to));

                    if (route.isEmpty() || route.size() > way.size()) {
                        route.clear();
                        route.addAll(way);
                    }
                }
            }
        }
        return route;
    }

    private boolean isConnected(Station station1, Station station2) {
        Set<Station> connected = stationIndex.getConnectedStations(station1);

        return connected.contains(station2);
    }

    private List<Station> getRouteViaConnectedLine(Station from, Station to) {
        Set<Station> fromConnected = stationIndex.getConnectedStations(from);
        Set<Station> toConnected = stationIndex.getConnectedStations(to);

        for (Station srcStation : fromConnected) {
            for (Station dstStation : toConnected) {
                if (srcStation.getLine().equals(dstStation.getLine())) {
                    return getRouteOnTheLine(srcStation, dstStation);
                }
            }
        }
        return null;
    }

    private List<Station> getRouteWithTwoConnections(Station from, Station to) {
        if (from.getLine().equals(to.getLine())) {
            return null;
        }

        ArrayList<Station> route = new ArrayList<>();

        List<Station> fromLineStations = from.getLine().getStations();
        List<Station> toLineStations = to.getLine().getStations();

        for (Station srcStation : fromLineStations) {
            for (Station dstStation : toLineStations) {
                List<Station> connectedLineRoute =
                    getRouteViaConnectedLine(srcStation, dstStation);
                if (connectedLineRoute == null) {
                    continue;
                }

                List<Station> way = new ArrayList<>();
                way.addAll(getRouteOnTheLine(from, srcStation));
                way.addAll(connectedLineRoute);
                way.addAll(getRouteOnTheLine(dstStation, to));

                if (route.isEmpty() || route.size() > way.size()) {
                    route.clear();
                    route.addAll(way);
                }
            }
        }

        return route;
    }

}
