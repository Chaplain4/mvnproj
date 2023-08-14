package enums;

public enum Severity {
    BLOCKER(1) {
        @Override
        public String getTimeToDo() {
            return "3 HOURS";
        }
    },
    CRITICAL(2) {
        @Override
        public String getTimeToDo() {
            return "8 HOURS";
        }
    },
    NOT_CRITICAL(3){
        @Override
        public String getTimeToDo() {
            return "48 HOURS";
        }
    },
    MINOR(4){
        @Override
        public String getTimeToDo() {
            return "168 HOURS";
        }
    };

    private int priority;

    Severity(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static Severity getSverityByPriority (int priority) {
        switch (priority) {
            case 1:
                return BLOCKER;
            case 2:
                return CRITICAL;
            case 3:
                return NOT_CRITICAL;
            case 4:
                return MINOR;
        }
        throw new IllegalArgumentException("No such priority");
    }

    public abstract String getTimeToDo();
}