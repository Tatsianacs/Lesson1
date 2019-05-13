import java.util.HashMap;
import java.util.Map;

public class WeekDays {
    private static Map<Integer, String> days;

    static {
        days = new HashMap<Integer, String>();
        days.put(1, "Monday");
        days.put(2, "Tuesday");
        days.put(3, "Wednesday");
        days.put(4, "Thursday");
        days.put(5, "Friday");
        days.put(6, "Saturday");
        days.put(7, "Sunday");
    }

    public String getDayName(int number) {
        return days.getOrDefault(number,"no such day");
    }
}
