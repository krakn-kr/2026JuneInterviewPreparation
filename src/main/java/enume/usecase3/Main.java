package enume.usecase3;

import enume.usecase1.Day;

public class Main {
    public String getActivity(Day day) {
        return switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working";
            case SATURDAY, SUNDAY -> "Resting";
            // No default needed! The compiler knows you've covered all days.
        };
    }
}
