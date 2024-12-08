package menu.model;

public enum DayOfTheWeek {
    MON(0),
    TUE(1),
    WED(2),
    THU(3),
    FRI(4);

    public final int index;

    DayOfTheWeek(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
