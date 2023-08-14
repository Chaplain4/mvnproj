package enums;

public enum Weekdays {
    MONDAY("MON", 1) {
        @Override
        public void work() {
            System.out.println("Working day");
        }
    },
    TUESDAY("TUE", 2) {
        @Override
        public void work() {
            System.out.println("Working day");
        }
    },
    WEDNESDAY("WED", 3) {
        @Override
        public void work() {
            System.out.println("Working day");
        }
    },
    THURSDAY("THU", 4) {
        @Override
        public void work() {
            System.out.println("Working day");
        }
    },
    FRIDAY("FRI", 5) {
        @Override
        public void work() {
            System.out.println("Working day");
        }
    },
    SATURDAY("SAT", 6) {
        @Override
        public void work() {
            System.out.println("Free day");
        }
    },
    SUNDAY("SUN", 7) {
        @Override
        public void work() {
            System.out.println("Free day");
        }
    };

    private String abbreviation;
    private int dayNumber;

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    Weekdays(String abbreviation, int dayNumber) {
        this.abbreviation = abbreviation;
        this.dayNumber = dayNumber;
    }

    abstract void work();

    public static Weekdays getWeekdayByNumber(int dayNumber) {
        switch (dayNumber) {
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THURSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
            case 7:
                return SUNDAY;
        }
        throw new IllegalArgumentException("Wrong day number");
    }

    public static Weekdays getWeekdayByAbbreviation(String abbreviation) {
        switch (abbreviation.toUpperCase()) {
            case "MON":
                return MONDAY;
            case "TUE":
                return TUESDAY;
            case "WED":
                return WEDNESDAY;
            case "THU":
                return THURSDAY;
            case "FRI":
                return FRIDAY;
            case "SAT":
                return SATURDAY;
            case "SUN":
                return SUNDAY;
        }
        throw new IllegalArgumentException("Wrong abbreviation");
    }
}
