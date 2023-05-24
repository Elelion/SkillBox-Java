package module_18_efficiency._18_19_practical_VoteAnalyzer;

import module_18_efficiency._18_14_lectire_indexing_and_optimization.TimePeriod;

import java.util.Date;
import java.util.TreeSet;

public class WorkTime {

    private TreeSet<TimePeriod> periods;

    /**
     * Set of TimePeriod objects
     */
    public WorkTime() {
        periods = new TreeSet<>();
    }

    public void addVisitTime(long visitTime) {
        Date visit = new Date(visitTime);
        TimePeriod newPeriod = new TimePeriod(visit, visit);
        for (TimePeriod period : periods) {
            if (period.compareTo(newPeriod) == 0) {
                period.appendTime(visit);
                return;
            }
        }
        periods.add(new TimePeriod(visit, visit));
    }

    public String toString() {
        String line = "";
        for (TimePeriod period : periods) {
            if (!line.isEmpty()) {
                line += ", ";
            }
            line += period;
        }
        return line;
    }
}

