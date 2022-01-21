package zjelles.jelles.items.bags.abstraction;

public enum BagSize {
    SMALL(9, "Small"),
    MEDIUM(18, "Medium"),
    LARGE(27, "Large");

    private int size;
    private String name;

    BagSize(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
