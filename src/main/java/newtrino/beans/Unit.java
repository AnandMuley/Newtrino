package newtrino.beans;

public class Unit {

    private String type;
    private double quantity;

    public Unit() {
    }

    public Unit(String type, double quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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
