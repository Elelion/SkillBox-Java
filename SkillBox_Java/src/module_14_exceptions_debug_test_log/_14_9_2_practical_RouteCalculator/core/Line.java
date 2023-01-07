package module_14_exceptions_debug_test_log._14_9_2_practical_RouteCalculator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * по сути обычный POJO
 */
public class Line implements Comparable<Line>
{
    private int number;
    private String name;
    private List<Station> stations;

    public Line(int number, String name)
    {
        this.number = number;
        this.name = name;
        stations = new ArrayList<>();
    }

    public int getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }

    public List<Station> getStations()
    {
        return stations;
    }

    /**
     * number и line.getNumber - объекты, которые нужно сравнить. Этот
     * метод возвращает ноль, если объекты равны. Он возвращает положительное
     * значение, если number больше, чем line.getNumber. В противном случае
     * возвращается отрицательное значение.
     */
    @Override
    public int compareTo(Line line)
    {
        return Integer.compare(number, line.getNumber());
    }

    /**
     * вызывает верхний public int compareTo(Line line)
     */
    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Line) obj) == 0;
    }
}
