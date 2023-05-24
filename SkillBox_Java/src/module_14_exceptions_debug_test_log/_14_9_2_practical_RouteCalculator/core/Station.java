package module_14_exceptions_debug_test_log._14_9_2_practical_RouteCalculator.core;

/**
 * аналогисно Line, те обычный POJO
 */
public class Station implements Comparable<Station>
{
    private Line line;
    private String name;

    public Station(String name, Line line)
    {
        this.name = name;
        this.line = line;
    }

    public Line getLine()
    {
        return line;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Station station)
    {
        int lineComparison = line.compareTo(station.getLine());

        if (lineComparison != 0) {
            return lineComparison;
        }

        return name.compareToIgnoreCase(station.getName());
    }

    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Station) obj) == 0;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
