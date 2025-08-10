package LLD.VendingMachine;

public enum Note {
    FIVE(5),
    TEN(10),
    TWENTY_FIVE(25),
    FIFTY(50);

    private final int note;
    Note(int note) {
        this.note = note;
    }

    public int getNote() {
        return note;
    }
}
