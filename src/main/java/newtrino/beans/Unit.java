package newtrino.beans;

public class Unit {

    private String type;
    private long quantity;

    public Unit() {
    }

    public Unit(String type, long quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
